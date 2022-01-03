package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.Hackathon.bialgenieapp.Actvities.Transit_Parking;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ParkingMainList extends Fragment {



    public ParkingMainList() {
        // Required empty public constructor
        super(R.layout.fragment_parking_main_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parking_main_list, container, false);

        FloatingActionButton fab=view.findViewById(R.id.fab1);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(getActivity(),TrackCharges.class));
            }
        });
        return view;
    }
}