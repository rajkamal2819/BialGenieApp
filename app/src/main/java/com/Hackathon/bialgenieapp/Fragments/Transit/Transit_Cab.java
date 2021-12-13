package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FragmentAuthAdapter;
import com.Hackathon.bialgenieapp.Adapters.FragmentTransitCabAdapter;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentTransitCabBinding;
import com.google.android.material.tabs.TabLayout;


public class Transit_Cab extends AppCompatActivity {

   View v;
    FragmentTransitCabBinding binding;
    FragmentTransitCabAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_transit__cab);
        viewPager = findViewById(R.id.viewpagerCab);
        tabLayout = findViewById(R.id.tabLayout_cab);

        viewPager.setAdapter(new FragmentTransitCabAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }
}