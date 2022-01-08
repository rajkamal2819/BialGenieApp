package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.tabs.TabLayout;


public class AppBasedTaxi extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    public AppBasedTaxi() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_app_based_taxi, container, false);
        viewPager = v.findViewById(R.id.viewpagerapp);
        tabLayout = v.findViewById(R.id.tabLayout_app);

        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), 15));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return v;
    }
}