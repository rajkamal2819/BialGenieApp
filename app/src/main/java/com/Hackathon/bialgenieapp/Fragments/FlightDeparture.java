package com.Hackathon.bialgenieapp.Fragments;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Queries.ArrDepQueryUtils;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentFlighsArrivalBinding;
import com.Hackathon.bialgenieapp.databinding.FragmentFlightDepartureBinding;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FlightDeparture extends Fragment {

    public FlightDeparture() {
        // Required empty public constructor
    }

    FragmentFlightDepartureBinding binding;
  //  private String Sample_Json_query = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/status/BLR/arr/2021/12/14/15?appId=3d44123a&appKey=ce3c12a840540d7528f086a02ccd3f2a&utc=true&numHours=5&maxFlights=5";

    private String Sample_Json_query = "";
    String jsonFirst = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/status/BLR/dep/";
    String jsonEnd = "?appId=3d44123a&appKey=ce3c12a840540d7528f086a02ccd3f2a&utc=true&numHours=5&maxFlights=5";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFlightDepartureBinding.inflate(getLayoutInflater());


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        String year = date.substring(0,4);
        String month = date.substring(5,7);
        String day = date.substring(8,10);
        String hours = date.substring(11,13);

        String dateCur = year + "/" + month +"/" + day + "/" + hours;
        jsonFirst += dateCur;
        Sample_Json_query = jsonFirst + jsonEnd;


        DepartureAsyncTask task = new DepartureAsyncTask();
        task.execute();

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<ArDepModel> booksInfos) {

        // bookList = booksInfos;

        /*CoursesItemAdapter sliderAdapter = new CoursesItemAdapter(booksInfos, binding.recyclerView, getApplicationContext(), R.layout.courses_item_specific, 2);
        binding.recyclerView.setAdapter(sliderAdapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));*/

      //  binding.textView3.setText(booksInfos.get(0).getAirportArrivalInformation().getAirportName()+"");
         binding.textView3.setText(booksInfos.get(0).getAirlines()+"");

    }

    private class DepartureAsyncTask extends AsyncTask<URL, Void, ArrayList<ArDepModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<ArDepModel> doInBackground(URL... urls) {
            ArrayList<ArDepModel> event = ArrDepQueryUtils.fetchFlightsData(Sample_Json_query);            //also we can use  urls[0]
            Log.i("CategoryCoursesActivity", Sample_Json_query);
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<ArDepModel> event) {

            //  binding.progressSpineer.setVisibility(View.GONE);

            if (event == null) {
                //  binding.emptyNoBook.setText("No Books Found");
                return;
            }

            updateUi(event);

        }

    }

}