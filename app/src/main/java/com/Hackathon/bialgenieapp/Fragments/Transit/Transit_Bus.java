package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.Database.BusTables;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Transit_Bus extends AppCompatActivity {



    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transit__bus);


        viewPager = findViewById(R.id.viewpagerBus);
        tabLayout = findViewById(R.id.tabLayout_bus);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),6));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }

}