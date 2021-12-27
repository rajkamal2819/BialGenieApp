package com.Hackathon.bialgenieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.databinding.FragmentTransitCabBinding;
import com.google.android.material.tabs.TabLayout;

public class ExploreAirport extends AppCompatActivity {
    View v;
    ExploreAirport binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_airport);
        t = findViewById(R.id.title_explore);
        viewPager = findViewById(R.id.viewpagerexplore);
        tabLayout = findViewById(R.id.tabexplore);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),5));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //api.openweathermap.org/data/2.5/weather?q=London&appid={39ea5ab9d85358c0658bcf9a4e44f9b6}
    }
}