package com.Hackathon.bialgenieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.databinding.ActivityFlightsDetailsBinding;

public class FlightsDetailsActivity extends AppCompatActivity {

    ActivityFlightsDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlightsDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArDepModel model = getIntent().getParcelableExtra("currentFlight");
        ArDepModel.airportInformation arrInfo = getIntent().getParcelableExtra("arAirportInfo");
        ArDepModel.airportInformation depInfo = getIntent().getParcelableExtra("depAirportInfo");
        int uniqueL = getIntent().getIntExtra("uniqueL", 0);

        String dateArrival = model.getArrivalLocalDate();
        String dateStr = dateArrival.substring(0, 10);
        String timeStr = dateArrival.substring(11, 16);

        //if arrival on blr then city 1 is BLR or else

        binding.date.setText(dateStr);
        binding.time2.setText(timeStr);
        binding.arrivalAirportTime.setText(timeStr);

        String dateDeparture = model.getDepartureLocalDate();
        String timeDep = dateDeparture.substring(11, 16);
        binding.depAirportTime.setText(timeDep);

        binding.time1.setText(timeDep);
        binding.airportCode2.setText(model.getArrivalAirport());
        binding.airportCode1.setText(model.getDepartureAirport());

        binding.airlinesName.setText(model.getAirlines());
        binding.flightNumber.setText(model.getCarrierCode() + model.getFlightNumber());

        binding.flightDuration.setText(model.getFlightDurationMinutes() + " Min");
        binding.serviceClasses.setText(model.getServiceClasses());

        // Arrival Details
        // binding.arrivalAirportTime.setText(arrInfo.getLocalTime());
        if (arrInfo != null) {
            binding.cityName2.setText(arrInfo.getCityName());
            binding.arAirportName.setText(arrInfo.getAirportName() + "\n ( " + arrInfo.getCityName() + " )");
        }
        if (depInfo != null) {
            binding.cityName1.setText(depInfo.getCityName());
            binding.departureAirportName.setText(depInfo.getAirportName() + "\n ( " + depInfo.getCityName() + " )");
        }
        binding.arrivalGate.setText(model.getArrivalGate());
        binding.depGate.setText(model.getDepartureGate());
        binding.arrivalTerminal.setText(model.getArrivalTerminal());
        binding.depTerminal.setText(model.getDepartureTerminal());


        /*String timeDepAirport = depInfo.getLocalTime();
        String t2 = timeDepAirport.substring(11,16);
       // binding.depAirportTime.setText(t2);
        Log.i("FlightDetailsActivity","time : "+t2);*/


        if (uniqueL == 1) {
            binding.landImage.setImageResource(R.drawable.ic_baseline_flight_land_24);
        } else if (uniqueL == 2) {
            binding.landImage.setImageResource(R.drawable.ic_baseline_flight_takeoff_24);
        }



        /*String dateArrival = model.getArrivalLocalDate();
        String dateStr = dateArrival.substring(0,10);
        String timeStr = dateArrival.substring(11,16);

        String dateArrival = model.getArrivalLocalDate();
        String dateStr = dateArrival.substring(0,10);
        String timeStr = dateArrival.substring(11,16);*/


    }
}