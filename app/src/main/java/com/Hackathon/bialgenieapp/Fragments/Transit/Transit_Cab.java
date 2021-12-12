package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FragmentFlightAdapter;
import com.Hackathon.bialgenieapp.Adapters.FragmentTransitCabAdapter;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentFlightsBinding;
import com.Hackathon.bialgenieapp.databinding.FragmentTransitCabBinding;
import com.google.android.material.tabs.TabLayout;


public class Transit_Cab extends Fragment {

   View v;
    FragmentTransitCabBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public Transit_Cab() {
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
        v = inflater.inflate(R.layout.fragment_transit__cab, container, false);
        binding = FragmentTransitCabBinding.inflate(getLayoutInflater());

        viewPager = binding.viewpagerCab;
        tabLayout = binding.tabLayoutCab;

        viewPager.setAdapter(new FragmentTransitCabAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        return binding.getRoot();
    }
}