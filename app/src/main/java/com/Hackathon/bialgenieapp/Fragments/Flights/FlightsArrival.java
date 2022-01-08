package com.Hackathon.bialgenieapp.Fragments.Flights;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.FlightItemAdapter;
import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Queries.ArrDepQueryUtils;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentFlighsArrivalBinding;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class FlightsArrival extends Fragment {

    public FlightsArrival() {
        // Required empty public constructor
    }

    FragmentFlighsArrivalBinding binding;

    private String Sample_Json_query = "";
    String jsonFirst = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/airport/status/BLR/arr/";
    String jsonEnd = "?appId=d5828495&appKey=694ea86653f38f22a40aca0d6f941543&utc=true&numHours=5&maxFlights=20";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFlighsArrivalBinding.inflate(getLayoutInflater());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);

        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        String hours = date.substring(11, 13);

        String dateCur = year + "/" + month + "/" + day + "/" + hours;
        jsonFirst += dateCur;
        Sample_Json_query = jsonFirst + jsonEnd;


        ArrivalAsyncTask task = new ArrivalAsyncTask();
        task.execute();

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<ArDepModel> flightInfo) {

        // bookList = booksInfos;

        if (flightInfo.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }

        FlightItemAdapter flightAdapter = new FlightItemAdapter(flightInfo,binding.recyclerViewArriving,getContext(),1);
        binding.recyclerViewArriving.setAdapter(flightAdapter);
        binding.recyclerViewArriving.setLayoutManager(new LinearLayoutManager(getContext()));
        flightAdapter.notifyDataSetChanged();

        //  binding.textView3.setText(booksInfos.get(0).getAirportArrivalInformation().getAirportName()+"");

    }

    private class ArrivalAsyncTask extends AsyncTask<URL, Void, ArrayList<ArDepModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<ArDepModel> doInBackground(URL... urls) {
            ArrayList<ArDepModel> event = ArrDepQueryUtils.fetchFlightsData(Sample_Json_query);            //also we can use  urls[0]
            Log.i("CategoryCoursesActivity", Sample_Json_query);
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<ArDepModel> event) {

            binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                binding.emptyTextView.setVisibility(View.VISIBLE);
                binding.emptyTextView.setText("No Books Found");
                return;
            }

            updateUi(event);

        }

    }

 }