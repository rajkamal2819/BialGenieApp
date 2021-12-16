package com.Hackathon.bialgenieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.databinding.ActivityFlightSearchBinding;
import com.google.android.material.tabs.TabLayout;

public class FlightSearchActivity extends AppCompatActivity {

    ActivityFlightSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlightSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpagerFlights.setAdapter(new FragmentAdapter(getSupportFragmentManager(),2));
        binding.tabLayout2.setupWithViewPager(binding.viewpagerFlights);
        binding.tabLayout2.setTabGravity(TabLayout.GRAVITY_FILL);

    }
}