package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Hackathon.bialgenieapp.R;


public class TransportationFragment extends Fragment {
    View v;
    CardView cab,train,parking,bus;


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
        // Inflate the layout for this fragment
        bus.setOnClickListener(new View.OnClickListener() {
                                           public final void onClick(View it) {
                                               Navigation.findNavController(v).navigate(R.id.action_transportationFragment_to_transit_Cab);
                                           }
                                       });
        cab.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Navigation.findNavController(v).navigate(R.id.action_transportationFragment_to_transit_Bus);
            }
        });
        train.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Navigation.findNavController(v).navigate(R.id.action_transportationFragment_to_transit_Train);
            }
        });
        parking.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Navigation.findNavController(v).navigate(R.id.action_transportationFragment_to_transit_Parking);
            }
        });
return v;
    }
}