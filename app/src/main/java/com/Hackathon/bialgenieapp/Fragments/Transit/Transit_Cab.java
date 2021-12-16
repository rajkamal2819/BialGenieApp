package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentTransitCabBinding;
import com.google.android.material.tabs.TabLayout;


public class Transit_Cab extends AppCompatActivity {

   View v;
    FragmentTransitCabBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_transit__cab);
        viewPager = findViewById(R.id.viewpagerCab);
        tabLayout = findViewById(R.id.tabLayout_cab);

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),4));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }
}