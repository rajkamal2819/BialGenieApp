package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.Hackathon.bialgenieapp.Adapters.FragmentAdapter;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityTransitCabBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;


public class Transit_Cab extends AppCompatActivity {

    View v;
    ActivityTransitCabBinding binding;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView back;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransitCabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
        homeTransaction.replace(R.id.main_content,new AppBasedTaxi());
        homeTransaction.commit();

        /* ------------------------Bottom normal Navigation Bar replacing with Bubble navigation bar----------------------*/

        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){
                    /**
                     * if we are in Activity then so i used getSupportFragmentManger()
                     * else if we were in fragment then use getFragmentManager()
                     */


                    case R.id.appTaxi:
                        transaction.replace(R.id.main_content,new AppBasedTaxi());
                        break;

                    case R.id.airportTaxi:
                        transaction.replace(R.id.main_content,new AirportTaxi());
                        break;

                    case R.id.carRentals:
                        transaction.replace(R.id.main_content,new CarRentals());
                        break;

                }

                transaction.commit();
                return true;

            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}