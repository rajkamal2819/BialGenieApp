package com.Hackathon.bialgenieapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hackathon.bialgenieapp.ExploreAirport_About;
import com.Hackathon.bialgenieapp.ExploreAirport_Photos;
import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Ola;

public class ExploreAirportAdapter extends FragmentPagerAdapter {
    public ExploreAirportAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ExploreAirportAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new ExploreAirport_About();
            case 1: return new ExploreAirport_Photos();
            default: return new ExploreAirport_About();
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
            title = "About";
        }
        else if(position==1){
            title = "Photos";
        }

        return title;
    }
}
