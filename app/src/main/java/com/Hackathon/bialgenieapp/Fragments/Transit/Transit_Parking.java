package com.Hackathon.bialgenieapp.Fragments.Transit;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FragmentParkingAdapter;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.tabs.TabLayout;


public class Transit_Parking extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transit__parking);

        viewPager=findViewById(R.id.view_pager_parkng);
        tabLayout=findViewById(R.id.tab_layout_parking);

        viewPager.setAdapter(new FragmentParkingAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

}