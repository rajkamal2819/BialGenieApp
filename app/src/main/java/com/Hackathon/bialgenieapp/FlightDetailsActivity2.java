package com.Hackathon.bialgenieapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Queries.ArrDepQueryUtils;
import com.Hackathon.bialgenieapp.databinding.ActivityFlightDetails2Binding;

import java.net.URL;
import java.util.ArrayList;

public class FlightDetailsActivity2 extends AppCompatActivity {

    ActivityFlightDetails2Binding binding;
    private String JsonResponseLink = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlightDetails2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        JsonResponseLink = getIntent().getStringExtra("linkFlight");
        AllFlightAsyncTask task = new AllFlightAsyncTask();
        task.execute();


    }

    protected void updateUi(ArrayList<ArDepModel> flightInfo) {

        // bookList = booksInfos;

        if (flightInfo.size() == 0) {
            Toast.makeText(getApplicationContext(),"NO DATA AVAILABLE",Toast.LENGTH_LONG).show();
        }
        else {

            ArDepModel model = flightInfo.get(0);
            ArDepModel.airportInformation arrInfo = model.getAirportArrivalInformation();
            ArDepModel.airportInformation depInfo = model.getAirportDepInformation();

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

            binding.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }

    }

private class AllFlightAsyncTask extends AsyncTask<URL, Void, ArrayList<ArDepModel>> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected ArrayList<ArDepModel> doInBackground(URL... urls) {
        ArrayList<ArDepModel> event = ArrDepQueryUtils.fetchFlightsData(JsonResponseLink);            //also we can use  urls[0]
        return event;
    }

    @Override
    protected void onPostExecute(ArrayList<ArDepModel> event) {

        binding.progressBar1.setVisibility(View.GONE);

        if (event == null) {
            Log.i("FlightsDetailsActivity", "NULL EVENT");
            return;
        }

        updateUi(event);

    }

}

}