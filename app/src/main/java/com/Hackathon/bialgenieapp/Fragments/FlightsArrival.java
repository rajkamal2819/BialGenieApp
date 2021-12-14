package com.Hackathon.bialgenieapp.Fragments;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Queries.ArrDepQueryUtils;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentFlighsArrivalBinding;

import java.net.URL;
import java.util.ArrayList;


public class FlightsArrival extends Fragment {

    public FlightsArrival() {
        // Required empty public constructor
    }

    FragmentFlighsArrivalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFlighsArrivalBinding.inflate(getLayoutInflater());


        return binding.getRoot();
    }


}