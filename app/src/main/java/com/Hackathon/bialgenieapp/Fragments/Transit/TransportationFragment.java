package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Hackathon.bialgenieapp.R;


public class TransportationFragment extends Fragment {
    View v;
    CardView cab,train,parking,bus;
    Button b;


    public TransportationFragment() {
        // Required empty public constructor

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_transportation, container, false);
        bus = v.findViewById(R.id.travel_bus);
        cab = v.findViewById(R.id.travel_cabs);
        train = v.findViewById(R.id.travel_train);
        parking = v.findViewById(R.id.travel_parking);
        b = v.findViewById(R.id.navigate);
        // Inflate the layout for this fragment
        bus.setOnClickListener(new View.OnClickListener() {
                                           public final void onClick(View it) {
                                             Intent i = new Intent(getActivity(),Transit_Bus.class);
                                             startActivity(i);

                                           }
                                       });
        cab.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Cab.class);
                startActivity(i);
            }
        });
        train.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Train.class);
                startActivity(i);
            }
        });

        parking.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Parking.class);
                startActivity(i);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=13.1986, 77.7066");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
return v;
    }
}