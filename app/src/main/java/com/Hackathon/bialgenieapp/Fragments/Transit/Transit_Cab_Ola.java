package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Hackathon.bialgenieapp.R;


public class Transit_Cab_Ola extends Fragment {



    public Transit_Cab_Ola() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_transit__cab__ola, container, false);
       /* r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        });*/
        Button b ;
        b = v.findViewById(R.id.ridebutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PackageManager pm = getActivity().getPackageManager();
                try {
                    pm.getPackageInfo("com.ubercab", PackageManager.GET_ACTIVITIES);
                    String uri = "uber://?action=setPickup&pickup=my_location&dropoff[latitude]=13.19864&dropoff[longitude]=77.7066&dropoff[nickname]=Kempegowda%20International%20Airport%20Bengaluru";
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                } catch (PackageManager.NameNotFoundException e) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab")));

                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.ubercab")));
                    }
                }
            }
        });


        return inflater.inflate(R.layout.fragment_transit__cab__ola, container, false);
    }
}