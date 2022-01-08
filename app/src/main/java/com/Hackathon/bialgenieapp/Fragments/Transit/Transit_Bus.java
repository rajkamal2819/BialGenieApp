package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.tabs.TabLayout;


public class Transit_Bus extends AppCompatActivity {



    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit__bus);



        viewPager = findViewById(R.id.viewpagerBus);
        tabLayout = findViewById(R.id.tabLayout_bus);



        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),6));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }

}