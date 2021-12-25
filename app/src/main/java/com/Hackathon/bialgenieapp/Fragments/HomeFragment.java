package com.Hackathon.bialgenieapp.Fragments;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.FlightSearchActivity;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentHomeBinding;

import java.util.List;


public class HomeFragment extends Fragment {
    ImageView i;
    public static final String SMS_SENT_ACTION = "com.andriodgifts.gift.SMS_SENT_ACTION";
    public static final String SMS_DELIVERED_ACTION = "com.andriodgifts.gift.SMS_DELIVERED_ACTION";
    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
         binding.siren.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                /* GPStracker g = new GPStracker(getApplicationContext());
                 Location l = g.getLocation();
                 if (l != null) {
                     double lat = l.getLatitude();
                     double lon = l.getLongitude();
                     String message = "http://maps.google.com/maps?saddr=" + lat + "," + lon;
                     String number = "xxxxxxxx";
                     SmsManager smsManager = SmsManager.getDefault();
                     StringBuffer smsBody = new StringBuffer();
                     smsBody.append(Uri.parse(message));
                     android.telephony.SmsManager.getDefault().sendTextMessage(number, null, smsBody.toString(), null, null);
                 }*/

                 String phoneNum = "9920645355";
                 String smsBody = "Hello Anii";

                 //Check if the phoneNumber is empty
                 if (phoneNum.isEmpty()) {
                     Toast.makeText(getContext(), "Please Enter a Phone Number", Toast.LENGTH_LONG).show();
                 } else {
                     sendSMS(phoneNum, smsBody);
                 }
             }

         });
        binding.flightSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FlightSearchActivity.class));
            }
        });
    /*    registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String message = null;
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        message = "Message Sent Successfully !";
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        message = "Error.";
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        message = "Error: No service.";
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        message = "Error: Null PDU.";
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        message = "Error: Radio off.";
                        break;
                }


            }


    }, new IntentFilter(SMS_SENT_ACTION));*/
        return binding.getRoot();
    }




    public void sendSMS(String phoneNumber, String smsMessage) {
        SmsManager sms = SmsManager.getDefault();
        List<String> messages = sms.divideMessage(smsMessage);
        for (String message : messages) {

            /*
             * sendTextMessage (String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent)
             *
             * Sent Intent: fired when the message is sent and indicates if it's successfully sent or not
             *
             * Delivery Intent: fired when the message is sent and delivered
             * */

            sms.sendTextMessage(phoneNumber, null, message, PendingIntent.getBroadcast(
                    getContext(), 0, new Intent(SMS_SENT_ACTION), 0), PendingIntent.getBroadcast(getContext(), 0, new Intent(SMS_DELIVERED_ACTION), 0));
        }
    }
}