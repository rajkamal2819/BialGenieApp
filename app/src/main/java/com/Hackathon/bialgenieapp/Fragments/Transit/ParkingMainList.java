package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.R;


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
        return inflater.inflate(R.layout.fragment_parking_main_list, container, false);
    }
}