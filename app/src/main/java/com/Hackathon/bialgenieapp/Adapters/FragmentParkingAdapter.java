package com.Hackathon.bialgenieapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.Hackathon.bialgenieapp.Fragments.Transit.ChargesFragment;
import com.Hackathon.bialgenieapp.Fragments.Transit.TrackCharges;

public class FragmentParkingAdapter extends FragmentPagerAdapter {


    public FragmentParkingAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull

    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               return new ChargesFragment();
       }

       return new TrackCharges();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Parking charges";


        }

        return "Track charges";
    }
}
