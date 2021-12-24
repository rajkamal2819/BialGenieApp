package com.Hackathon.bialgenieapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hackathon.bialgenieapp.Fragments.FlightSearch;
import com.Hackathon.bialgenieapp.Fragments.FlightTrack;

public class FragmentFlightAdapter extends FragmentPagerAdapter {
    public FragmentFlightAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentFlightAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new FlightSearch();
            case 1: return new FlightTrack();
            default: return new FlightTrack();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if(position==0){
            title = "Search Flights";
        }
        else if(position==1){
            title = "Track Flights";
        }

        return title;
    }

}
