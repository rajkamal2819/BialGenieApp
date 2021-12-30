package com.Hackathon.bialgenieapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.ExploreAirport_About;
import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.ExploreAirport_Photos;
import com.Hackathon.bialgenieapp.Fragments.Flights.AllFlights;
import com.Hackathon.bialgenieapp.Fragments.Flights.DirectFlights;
import com.Hackathon.bialgenieapp.Fragments.Flights.FlightsArrival;
import com.Hackathon.bialgenieapp.Fragments.Flights.FlightDeparture;
import com.Hackathon.bialgenieapp.Fragments.Flights.FromToFlights;
import com.Hackathon.bialgenieapp.Fragments.Flights.NumSearchFlights;
import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Ola;
import com.Hackathon.bialgenieapp.Fragments.Transit.Transit_Cab_Uber;
import com.Hackathon.bialgenieapp.Fragments.restaurants.PostSecurityRes;
import com.Hackathon.bialgenieapp.Fragments.restaurants.PreSecurityRes;

public class FragmentAdapter extends FragmentPagerAdapter {

    int uniqueL;

    public FragmentAdapter(@NonNull FragmentManager fm, int uniqueL) {
        super(fm);
        this.uniqueL = uniqueL;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (uniqueL == 1) {
            switch (position) {
                case 0:
                    return new FlightsArrival();
                case 1:
                    return new FlightDeparture();
                default:
                    return new FlightDeparture();
            }
        } else if (uniqueL == 2) {                       // uniqueL == 2
            switch (position) {
                case 0:
                    return new FromToFlights();
                case 1:
                    return new NumSearchFlights();
                default:
                    return new FromToFlights();
            }
        } else if (uniqueL == 4) {
            switch (position) {
                case 0:
                    return new Transit_Cab_Uber();
                case 1:
                    return new Transit_Cab_Ola();
                default:
                    return new Transit_Cab_Ola();
            }
        } else if (uniqueL == 5) {
            switch (position) {
                case 0:
                    return new ExploreAirport_About();
                case 1:
                    return new ExploreAirport_Photos();
                default:
                    return new ExploreAirport_About();
            }
        } else if (uniqueL == 7) {
            switch (position) {
                case 0:
                    return new PreSecurityRes();
                case 1:
                    return new PostSecurityRes();
                default:
                    return new PreSecurityRes();
            }
        } else {
            switch (position) {
                case 0:
                    return new AllFlights();
                case 1:
                    return new DirectFlights();
                default:
                    return new AllFlights();
            }
        }

    }


    @Override
    public int getCount() {
        return 2;        // for now both the Activity's and Fragment's have 2 child
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if(uniqueL == 1) {
            if (position == 0) {
                title = "Arrivals";
            } else if (position == 1) {
                title = "Departures";
            }
        }
        else if(uniqueL == 2){
            if(position==0){
                title = "From / To";
            }
            else if(position==1){
                title = "Flight Number";
            }
        }
        else if(uniqueL == 4){
            if(position==0){
                title = "Uber";
            }
            else if(position==1){
                title = "Ola";
            }
        }   else if(uniqueL == 5){
            if(position==0){
                title = "About";
            }
            else if(position==1){
                title = "Photos";
            }
        } else if(uniqueL == 7){
            if(position==0){
                title = "Pre-Security";
            }
            else if(position==1){
                title = "Post-Security";
            }
        }
        else {
            if(position==0){
                title = "All Flights";
            }
            else if(position==1){
                title = "Direct";
            }
        }

        return title;
    }

}
