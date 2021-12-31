package com.Hackathon.bialgenieapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Ola;
import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Uber;
import com.Hackathon.bialgenieapp.Fragments.TransitBusFly;
import com.Hackathon.bialgenieapp.Fragments.TransitBusVV;

public class TransitBusAdapter extends FragmentPagerAdapter{
    public TransitBusAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public TransitBusAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new TransitBusVV();
            case 1: return new TransitBusFly();
            default: return new TransitBusVV();
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
            title = "Vayu Vajra";
        }
        else if(position==1){
            title = "Fly Bus";
        }

        return title;
    }
}
