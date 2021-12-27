package com.Hackathon.bialgenieapp.Fragments;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.ExploreAirport;
import com.Hackathon.bialgenieapp.FlightSearchActivity;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentHomeBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.List;


public class HomeFragment extends Fragment {
    int LOCATION_REQUEST_CODE = 10001;

    StringBuffer smsBody = new StringBuffer();
    public static final String SMS_SENT_ACTION = "com.andriodgifts.gift.SMS_SENT_ACTION";
    public static final String SMS_DELIVERED_ACTION = "com.andriodgifts.gift.SMS_DELIVERED_ACTION";

    public HomeFragment() {
        // Required empty public constructor
    }
    String uri;

    FusedLocationProviderClient fusedLocationProviderClient;
    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
        binding.alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String phoneNum = "9920645355";
                 smsBody.append(" Here is my location!");

                //Check if the phoneNumber is empty
                if (phoneNum.isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter a Phone Number", Toast.LENGTH_LONG).show();
                } else {
                    sendSMS(phoneNum, smsBody.toString());
                    Toast.makeText(getContext(), "Location shared with the authorities", Toast.LENGTH_LONG).show();
                }

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

                } else  {
                    Log.d(TAG, "onSuccess: Location was null...");
                }
            }
        });

        locationTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, "onFailure: " + e.getLocalizedMessage() );
            }
        });
    }

    private void askLocationPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                Log.d(TAG, "askLocationPermission: you should show an alert dialog...");
                ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                getLastLocation();
            } else {
                //Permission not granted
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