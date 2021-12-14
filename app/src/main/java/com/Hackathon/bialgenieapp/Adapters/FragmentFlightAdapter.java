package com.Hackathon.bialgenieapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hackathon.bialgenieapp.Fragments.FlightsArrival;
import com.Hackathon.bialgenieapp.Fragments.FlightDeparture;

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
            case 0: return new FlightsArrival();
            case 1: return new FlightDeparture();
            default: return new FlightDeparture();
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
            title = "Arrivals";
        }
        else if(position==1){
            title = "Departures";
        }

        return title;
    }

}
