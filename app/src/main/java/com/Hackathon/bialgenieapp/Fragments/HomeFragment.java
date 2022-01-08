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
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
import com.Hackathon.bialgenieapp.Actvities.FAQ_main;
import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.ExploreAirport;
import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.FlightSearchActivity;
import com.Hackathon.bialgenieapp.Actvities.Hotels.HotelsActivity;
import com.Hackathon.bialgenieapp.Actvities.RestaurantsActivity;
import com.Hackathon.bialgenieapp.Actvities.ShoppingActivity;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.databinding.FragmentHomeBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import omari.hamza.storyview.StoryView;
import omari.hamza.storyview.callback.StoryClickListeners;
import omari.hamza.storyview.model.MyStory;


public class HomeFragment extends Fragment {
    int LOCATION_REQUEST_CODE = 10001;

    StringBuffer smsBody = new StringBuffer();
    public static final String SMS_SENT_ACTION = "com.andriodgifts.gift.SMS_SENT_ACTION";
    public static final String SMS_DELIVERED_ACTION = "com.andriodgifts.gift.SMS_DELIVERED_ACTION";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private String LOG_TAG = HomeFragment.class.getSimpleName();

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

        binding.faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FAQ_main.class));
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

        StoriesTask task = new StoriesTask();
        task.execute();

        return binding.getRoot();
    }

    public String getJsonResponse(String fileUrl) {

        BufferedInputStream stream = null;
        try {
            URL fileURL = new URL(fileUrl);
            URLConnection connection = fileURL.openConnection();
            connection.connect();
            stream = new java.io.BufferedInputStream(connection.getInputStream());

            String response = readFromStream(stream);
            Log.d(LOG_TAG, response);

            return response;
        } catch (Exception e) {
            Log.e("MY_LOG_TAG", "I got an error", e);
        }
        return null;
    }

    private class StoriesTask extends AsyncTask<URL, Void, String> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected String doInBackground(URL... urls) {

            String response = getJsonResponse("https://bialtable.file.core.windows.net/otherfiles/announcements.json?sp=r&st=2022-01-07T06:37:41Z&se=2022-03-08T06:37:00Z&sv=2020-08-04&sig=0afGn998X4dfj57ZN%2F%2B4TvkiRbP8cRcFK%2BVxUhNrzMI%3D&sr=f");
            return response;
        }

        @Override
        protected void onPostExecute(String response) {

            if (response == null) {
                Log.i(LOG_TAG, "NULL Response");
                return;
            }
            initializeStories(response);
        }

    }

    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        Log.i(LOG_TAG, "Reading from Stream");
        Log.d(LOG_TAG, output.toString());
        return output.toString();
    }

    public void initializeStories(String response) {

        try {
            JSONObject obj = new JSONObject(response);

            JSONObject covidObj = obj.getJSONObject("covid19");
            ArrayList<MyStory> myStories = new ArrayList<>();
            JSONArray stories = covidObj.getJSONArray("info");
            for (int i = 0; i < stories.length(); i++) {
                JSONObject curObj = stories.getJSONObject(i);
                myStories.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.covidStory.setPortionsCount(stories.length());
            binding.covidStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(covidObj.getString("heading")) // Default is Hidden
                                        .setSubtitleText(covidObj.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(covidObj.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

            JSONObject atAirport = obj.getJSONObject("atAirport");
            ArrayList<MyStory> myStories1 = new ArrayList<>();
            JSONArray stories1 = atAirport.getJSONArray("info");
            for (int i = 0; i < stories1.length(); i++) {
                JSONObject curObj = stories1.getJSONObject(i);
                myStories1.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.airportStory.setPortionsCount(stories1.length());

            binding.airportStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories1) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(atAirport.getString("heading")) // Default is Hidden
                                        .setSubtitleText(atAirport.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(atAirport.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

            JSONObject premiumServices = obj.getJSONObject("premiumServices");
            ArrayList<MyStory> myStories2 = new ArrayList<>();
            JSONArray stories2 = premiumServices.getJSONArray("info");
            for (int i = 0; i < stories2.length(); i++) {
                JSONObject curObj = stories2.getJSONObject(i);
                myStories2.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.premiumServicesStory.setPortionsCount(stories2.length());
            binding.premiumServicesStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories2) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(premiumServices.getString("heading")) // Default is Hidden
                                        .setSubtitleText(premiumServices.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(premiumServices.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

            JSONObject security = obj.getJSONObject("security");
            ArrayList<MyStory> myStories3 = new ArrayList<>();
            JSONArray stories3 = security.getJSONArray("info");
            for (int i = 0; i < stories3.length(); i++) {
                JSONObject curObj = stories3.getJSONObject(i);
                myStories3.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.securityStory.setPortionsCount(stories3.length());
            binding.securityStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories3) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(security.getString("heading")) // Default is Hidden
                                        .setSubtitleText(security.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(security.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

            JSONObject visa = obj.getJSONObject("visa");
            ArrayList<MyStory> myStories4 = new ArrayList<>();
            JSONArray stories4 = visa.getJSONArray("info");
            for (int i = 0; i < stories4.length(); i++) {
                JSONObject curObj = stories4.getJSONObject(i);
                myStories4.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.visaStory.setPortionsCount(stories4.length());
            binding.visaStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories4) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(visa.getString("heading")) // Default is Hidden
                                        .setSubtitleText(visa.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(visa.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

            JSONObject regulatoryFunctions = obj.getJSONObject("regulatoryFunctions");
            ArrayList<MyStory> myStories5 = new ArrayList<>();
            JSONArray stories5 = regulatoryFunctions.getJSONArray("info");
            for (int i = 0; i < stories5.length(); i++) {
                JSONObject curObj = stories5.getJSONObject(i);
                myStories5.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.regulatoryFunctionsStory.setPortionsCount(stories5.length());
            binding.regulatoryFunctionsStory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories5) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(regulatoryFunctions.getString("heading")) // Default is Hidden
                                        .setSubtitleText(regulatoryFunctions.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(regulatoryFunctions.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

            JSONObject passangerServices = obj.getJSONObject("passangerServices");
            ArrayList<MyStory> myStories6 = new ArrayList<>();
            JSONArray stories6 = passangerServices.getJSONArray("info");
            for (int i = 0; i < stories6.length(); i++) {
                JSONObject curObj = stories6.getJSONObject(i);
                myStories6.add(new MyStory(curObj.getString("image"), null, curObj.getString("description")));
            }
            binding.passangerServices.setPortionsCount(stories6.length());
            binding.passangerServices.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                new StoryView.Builder(getActivity().getSupportFragmentManager())
                                        .setStoriesList(myStories6) // Required
                                        .setStoryDuration(5000) // Default is 2000 Millis (2 Seconds)
                                        .setTitleText(passangerServices.getString("heading")) // Default is Hidden
                                        .setSubtitleText(passangerServices.getString("subHeading")) // Default is Hidden
                                        .setTitleLogoUrl(passangerServices.getString("logoUrl")) // Default is Hidden
                                        .setStoryClickListeners(new StoryClickListeners() {
                                            @Override
                                            public void onDescriptionClickListener(int position) {
                                                //your action
                                            }

                                            @Override
                                            public void onTitleIconClickListener(int position) {
                                                //your action
                                            }
                                        }) // Optional Listeners
                                        .build() // Must be called before calling show method
                                        .show();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    r.run();
                }
            });

        } catch (JSONException e) {
            Log.i(LOG_TAG, e.getMessage());
        }

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
                        Log.d("HomeFragment", "Taken Permissions");
                        Toast.makeText(getContext(), "Location shared with the Authorities", Toast.LENGTH_LONG).show();

                    }

                    Toast.makeText(getContext(), "Please Give Permissions to send sms From Settings", Toast.LENGTH_SHORT).show();

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