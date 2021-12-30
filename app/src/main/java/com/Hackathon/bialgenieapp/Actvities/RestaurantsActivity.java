package com.Hackathon.bialgenieapp.Actvities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Models.RestaurantsModel;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.Queries.RestaurantQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityRestaurantsBinding;
import com.google.android.material.tabs.TabLayout;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.net.URL;
import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    ActivityRestaurantsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpagerFlights.setAdapter(new FragmentAdapter(getSupportFragmentManager(),7));
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