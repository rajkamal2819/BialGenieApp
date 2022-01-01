package com.Hackathon.bialgenieapp.Actvities.Hotels;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityHotelsBinding;
import com.google.android.material.tabs.TabLayout;

import java.net.URL;
import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {

    ActivityHotelsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), 11));
        binding.tabLayout2.setupWithViewPager(binding.viewPager);
        binding.tabLayout2.setTabGravity(TabLayout.GRAVITY_FILL);

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}