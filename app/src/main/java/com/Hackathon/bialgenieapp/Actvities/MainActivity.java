package com.Hackathon.bialgenieapp.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

import com.Hackathon.bialgenieapp.Fragments.Flights.FlightsFragment;
import com.Hackathon.bialgenieapp.Fragments.HomeFragment;
/*import com.Hackathon.bialgenieapp.Fragments.MapsFragment;*/
import com.Hackathon.bialgenieapp.Fragments.MapsFragment;
import com.Hackathon.bialgenieapp.Fragments.MoreFragment;
import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Home;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;


public class MainActivity extends AppCompatActivity {

    ImageView i;
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
                        transaction.replace(R.id.main_content, new Transit_Home());
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
