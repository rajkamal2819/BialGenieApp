package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Actvities.Transit_Parking;
import com.Hackathon.bialgenieapp.customdialogs.CustomProgressBar;
import com.Hackathon.bialgenieapp.databinding.FragmentTransportationBinding;


public class TransportationFragment extends Fragment {


    public TransportationFragment() {
        // Required empty public constructor

    }

    FragmentTransportationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTransportationBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        binding.travelBus.setOnClickListener(new View.OnClickListener() {
                                           public final void onClick(View it) {
                                             Intent i = new Intent(getActivity(),Transit_Bus.class);
                                             startActivity(i);

                                           }
                                       });
        binding.travelCab.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Cab.class);
                startActivity(i);
            }
        });
        binding.traveTrains.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Train.class);
                startActivity(i);
            }
        });

        CustomProgressBar progressBar=new CustomProgressBar(getActivity());

        binding.travelParking.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(), Transit_Parking.class);
                startActivity(i);
                CustomProgressBar.startLoading();
            }
        });

        return binding.getRoot();
    }

}