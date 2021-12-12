package com.Hackathon.bialgenieapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FragmentFlightAdapter;
import com.Hackathon.bialgenieapp.databinding.FragmentFlightsBinding;
import com.google.android.material.tabs.TabLayout;


public class FlightsFragment extends Fragment {

    public FlightsFragment() {
        // Required empty public constructor
    }

    FragmentFlightsBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFlightsBinding.inflate(getLayoutInflater());

        viewPager = binding.viewpagerFlights;
        tabLayout = binding.tabLayout2;

        viewPager.setAdapter(new FragmentFlightAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        return binding.getRoot();
    }

}