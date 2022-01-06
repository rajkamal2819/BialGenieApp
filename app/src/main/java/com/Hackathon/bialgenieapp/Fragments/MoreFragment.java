package com.Hackathon.bialgenieapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Actvities.ChatBotActivity;
import com.Hackathon.bialgenieapp.Actvities.FeedbackForm;
import com.Hackathon.bialgenieapp.LostAndFound;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentMoreBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;
import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.http.IHttpRequest;
import com.microsoft.graph.models.extensions.Drive;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.IPublicClientApplication;
import com.microsoft.identity.client.ISingleAccountPublicClientApplication;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.SilentAuthenticationCallback;
import com.microsoft.identity.client.exception.MsalException;


public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }

    FragmentMoreBinding binding;
    private static String LOG_TAG = MoreFragment.class.getSimpleName();

    FloatingActionButton googleBtn;
    private static final String TAG = MoreFragment.class.getSimpleName();

    private final static String[] SCOPES = {"Files.Read"};
    /* Azure AD v2 Configs */
    final static String AUTHORITY = "https://login.microsoftonline.com/common";
    private ISingleAccountPublicClientApplication mSingleAccountApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMoreBinding.inflate(getLayoutInflater());


        binding.lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LostAndFound.class));
            }
        });

        binding.feedbackForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), FeedbackForm.class));
            }
        });


        initializeUI();

        PublicClientApplication.createSingleAccountPublicClientApplication(getContext(),
                R.raw.auth_config_single_account, new IPublicClientApplication.ISingleAccountApplicationCreatedListener() {
                    @Override
                    public void onCreated(ISingleAccountPublicClientApplication application) {
                        mSingleAccountApp = application;
                        loadAccount();
                    }
                    @Override
                    public void onError(MsalException exception) {
                        displayError(exception);
                    }
                });


        return  binding.getRoot();
    }


    //When app comes to the foreground, load existing account to determine if user is signed in
    private void loadAccount() {
        if (mSingleAccountApp == null) {
            return;
        }

        mSingleAccountApp.getCurrentAccountAsync(new ISingleAccountPublicClientApplication.CurrentAccountCallback() {
            @Override
            public void onAccountLoaded(@Nullable IAccount activeAccount) {
                // You can use the account data to update your UI or your app database.
                updateUI(activeAccount);
            }

            @Override
            public void onAccountChanged(@Nullable IAccount priorAccount, @Nullable IAccount currentAccount) {
                if (currentAccount == null) {
                    // Perform a cleanup task as the signed-in account changed.
                    performOperationOnSignOut();
                }
            }

            @Override
            public void onError(@NonNull MsalException exception) {
                displayError(exception);
            }
        });
    }

    private void initializeUI(){

        //Sign in user
        binding.signIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (mSingleAccountApp == null) {
                    return;
                }
                mSingleAccountApp.signIn(getActivity(), null, SCOPES, getAuthInteractiveCallback());
            }
        });

        //Sign out user
        binding.singOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSingleAccountApp == null){
                    return;
                }
                mSingleAccountApp.signOut(new ISingleAccountPublicClientApplication.SignOutCallback() {
                    @Override
                    public void onSignOut() {
                        updateUI(null);
                        performOperationOnSignOut();
                    }
                    @Override
                    public void onError(@NonNull MsalException exception){
                        displayError(exception);
                    }
                });
            }
        });

        //Interactive
        /*callGraphApiInteractiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSingleAccountApp == null) {
                    return;
                }
                mSingleAccountApp.acquireToken(MainActivity.this, SCOPES, getAuthInteractiveCallback());
            }
        });*/

        //Silent
        /*callGraphApiSilentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSingleAccountApp == null){
                    return;
                }
                mSingleAccountApp.acquireTokenSilentAsync(SCOPES, AUTHORITY, getAuthSilentCallback());
            }
        });*/

    }

    private AuthenticationCallback getAuthInteractiveCallback() {
        return new AuthenticationCallback() {
            @Override
            public void onSuccess(IAuthenticationResult authenticationResult) {
                /* Successfully got a token, use it to call a protected resource - MSGraph */
                Log.d(TAG, "Successfully authenticated");
                /* Update UI */
                updateUI(authenticationResult.getAccount());
                /* call graph */
                callGraphAPI(authenticationResult);
            }

            @Override
            public void onError(MsalException exception) {
                /* Failed to acquireToken */
                Log.d(TAG, "Authentication failed: " + exception.toString());
                displayError(exception);
            }
            @Override
            public void onCancel() {
                /* User canceled the authentication */
                Log.d(TAG, "User cancelled login.");
            }
        };
    }

    private SilentAuthenticationCallback getAuthSilentCallback() {
        return new SilentAuthenticationCallback() {
            @Override
            public void onSuccess(IAuthenticationResult authenticationResult) {
                Log.d(TAG, "Successfully authenticated");
                callGraphAPI(authenticationResult);
            }
            @Override
            public void onError(MsalException exception) {
                Log.d(TAG, "Authentication failed: " + exception.toString());
                displayError(exception);
            }
        };
    }

    private void callGraphAPI(IAuthenticationResult authenticationResult) {

        final String accessToken = authenticationResult.getAccessToken();

        IGraphServiceClient graphClient =
                GraphServiceClient
                        .builder()
                        .authenticationProvider(new IAuthenticationProvider() {
                            @Override
                            public void authenticateRequest(IHttpRequest request) {
                                Log.d(TAG, "Authenticating request," + request.getRequestUrl());
                                request.addHeader("Authorization", "Bearer " + accessToken);
                            }
                        })
                        .buildClient();
        graphClient
                .me()
                .drive()
                .buildRequest()
                .get(new ICallback<Drive>() {
                    @Override
                    public void success(final Drive drive) {
                        Log.d(TAG, "Found Drive " + drive.id);
                        displayGraphResult(drive.getRawObject());
                    }

                    @Override
                    public void failure(ClientException ex) {
                        displayError(ex);
                    }
                });
    }

    private void updateUI(@Nullable final IAccount account) {
        if (account != null) {
            binding.signIn.setEnabled(false);
            /*signInButton.setEnabled(false);
            signOutButton.setEnabled(true);
            callGraphApiInteractiveButton.setEnabled(true);
            callGraphApiSilentButton.setEnabled(true);*/
            binding.userName.setText(account.getUsername());
            binding.userId.setText(account.getId());
            binding.singOut.setVisibility(View.VISIBLE);
            binding.signIn.setVisibility(View.INVISIBLE);
        } else {
            //  binding.signIn.setEnabled(true);
           /* signOutButton.setEnabled(false);
            callGraphApiInteractiveButton.setEnabled(false);
            callGraphApiSilentButton.setEnabled(false); */
            binding.userName.setText("NO ACCOUNT LOGGED IN");
            binding.userId.setText("Null");
            binding.singOut.setVisibility(View.INVISIBLE);
            binding.signIn.setVisibility(View.VISIBLE);
            // logTextView.setText("");

        }
    }

    private void displayError(@NonNull final Exception exception) {
       // binding.msg.setText(exception.toString());
        Log.i("Authentication","Error: "+exception.toString());
    }

    private void displayGraphResult(@NonNull final JsonObject graphResponse) {
       // binding.msg.setText(graphResponse.toString());
        Log.i("Authentication","Error: "+graphResponse.toString());
    }

    private void performOperationOnSignOut() {
        final String signOutText = "Signed Out.";
       // binding.userInfo.setText("");
        Toast.makeText(getContext(), signOutText, Toast.LENGTH_SHORT)
                .show();
    }

}