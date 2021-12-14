package com.Hackathon.bialgenieapp.Adapters;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Ola;
import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Uber;

public class FragmentTransitCabAdapter extends FragmentPagerAdapter {
    public FragmentTransitCabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public FragmentTransitCabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new Transit_Cab_Uber();
            case 1: return new Transit_Cab_Ola();
            default: return new Transit_Cab_Ola();
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
            title = "Uber";
        }
        else if(position==1){
            title = "Ola";
        }

        return title;
    }

}