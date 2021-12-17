package com.Hackathon.bialgenieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.databinding.ActivityFromToFlightResultsBinding;
import com.google.android.material.tabs.TabLayout;

public class FromToFlightResults extends AppCompatActivity {

    ActivityFromToFlightResultsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFromToFlightResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpagerFlights.setAdapter(new FragmentAdapter(getSupportFragmentManager(),5));
        binding.tabLayout2.setupWithViewPager(binding.viewpagerFlights);
        binding.tabLayout2.setTabGravity(TabLayout.GRAVITY_FILL);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}