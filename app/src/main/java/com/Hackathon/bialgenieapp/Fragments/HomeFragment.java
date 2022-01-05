package com.Hackathon.bialgenieapp.Fragments;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Actvities.ChatBotActivity;
import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.ExploreAirport;
import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.FlightSearchActivity;
import com.Hackathon.bialgenieapp.Actvities.Hotels.HotelsActivity;
import com.Hackathon.bialgenieapp.Actvities.RestaurantsActivity;
import com.Hackathon.bialgenieapp.Actvities.ShoppingActivity;
import com.Hackathon.bialgenieapp.databinding.FragmentHomeBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class HomeFragment extends Fragment {
    int LOCATION_REQUEST_CODE = 10001;

    StringBuffer smsBody = new StringBuffer();
    public static final String SMS_SENT_ACTION = "com.andriodgifts.gift.SMS_SENT_ACTION";
    public static final String SMS_DELIVERED_ACTION = "com.andriodgifts.gift.SMS_DELIVERED_ACTION";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    FloatingActionButton chatbot ;

    public HomeFragment() {
        // Required empty public constructor
    }

    String uri;
    String phoneNum = "9920645355";

    FusedLocationProviderClient fusedLocationProviderClient;
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.SEND_SMS)) {
                Log.i("HomeFragment", "Checking SMS permissions");
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);

            }
        }
        binding.chatBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),ChatBotActivity.class);
                startActivity(i);
            }
        });

        binding.alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                popUpEditText();

             /*

                //Check if the phoneNumber is empty
                if (phoneNum.isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter a Phone Number", Toast.LENGTH_LONG).show();
                } else {
                    sendSMS(phoneNum, smsBody.toString());
                    Toast.makeText(getContext(), "Location shared with the authorities", Toast.LENGTH_LONG).show();
                }*/

            }

        });

        binding.chatBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ChatBotActivity.class));
            }
        });

        binding.flightSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FlightSearchActivity.class));
            }
        });

        binding.exploreAirport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ExploreAirport.class);
                startActivity(i);
            }
        });

        binding.restuarants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), RestaurantsActivity.class));
            }
        });

        binding.shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ShoppingActivity.class));
            }
        });

        binding.hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HotelsActivity.class));
            }
        });

        return binding.getRoot();
    }


    @Override
    public void onStart() {
        super.onStart();
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLastLocation();
        } else {
            askLocationPermission();
        }

    }


    private void popUpEditText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Comments");

        final EditText input = new EditText(getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                smsBody.append(" " + input.getText().toString());

                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.SEND_SMS)) {

                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.SEND_SMS},
                                MY_PERMISSIONS_REQUEST_SEND_SMS);
                        sendSMS(phoneNum, smsBody.toString());
                        Log.d("HomeFragment","Taken Permissions");
                        Toast.makeText(getContext(), "Location shared with the Authorities", Toast.LENGTH_LONG).show();

                    }

                    Toast.makeText(getContext(),"Please Give Permissions to send sms From Settings",Toast.LENGTH_SHORT).show();

                } else {
                    sendSMS(phoneNum, smsBody.toString());
                    Toast.makeText(getContext(), "Location shared with the Authorities", Toast.LENGTH_LONG).show();
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    private void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> locationTask = fusedLocationProviderClient.getLastLocation();

        locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    //We have a location
                    uri = "http://maps.google.com/maps?q=" + location.getLatitude() + "," + location.getLongitude();
                    smsBody.append(Uri.parse(uri));

                } else {
                    Log.d(TAG, "onSuccess: Location was null...");
                }
            }
        });

        locationTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure: " + e.getLocalizedMessage());
            }
        });
    }

    private void askLocationPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                Log.d(TAG, "askLocationPermission: you should show an alert dialog...");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                getLastLocation();
            } else {
                //Permission not granted
            }
        } else if (requestCode == MY_PERMISSIONS_REQUEST_SEND_SMS) {
            Toast.makeText(getContext(), "onrequestpermission", Toast.LENGTH_LONG).show();
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                sendSMS(phoneNum, smsBody.toString());


            } else {
                Toast.makeText(getContext(),
                        "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                return;
            }
        }


    }


    public void sendSMS(String phoneNumber, String smsMessage) {
        SmsManager sms = SmsManager.getDefault();
        List<String> messages = sms.divideMessage(smsMessage);
        for (String message : messages) {


            sms.sendTextMessage(phoneNumber, null, message, PendingIntent.getBroadcast(
                    getContext(), 0, new Intent(SMS_SENT_ACTION), 0), PendingIntent.getBroadcast(getContext(), 0, new Intent(SMS_DELIVERED_ACTION), 0));
        }
    }
}