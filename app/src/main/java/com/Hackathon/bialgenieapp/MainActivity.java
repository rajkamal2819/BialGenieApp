package com.Hackathon.bialgenieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.Hackathon.bialgenieapp.Fragments.FlightsFragment;
import com.Hackathon.bialgenieapp.Fragments.HomeFragment;
import com.Hackathon.bialgenieapp.Fragments.MapsFragment;
import com.Hackathon.bialgenieapp.Fragments.MoreFragment;
import com.Hackathon.bialgenieapp.Fragments.TransportationFragment;
import com.Hackathon.bialgenieapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.iammert.library.readablebottombar.ReadableBottomBar;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
        homeTransaction.replace(R.id.main_content, new HomeFragment());
        homeTransaction.commit();

        binding.bottomNav.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (i) {
                    case 0:
                        transaction.replace(R.id.main_content, new HomeFragment());
                        break;
                    case 1:
                        transaction.replace(R.id.main_content, new FlightsFragment());
                        break;
                    case 2:
                        transaction.replace(R.id.main_content, new MapsFragment());
                        break;
                    case 3:
                        transaction.replace(R.id.main_content, new TransportationFragment());
                        break;

                    case 4:
                        transaction.replace(R.id.main_content, new MoreFragment());
                        break;
                }
                transaction.commit();
            }
        });

    }
}
