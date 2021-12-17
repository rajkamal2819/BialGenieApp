package com.Hackathon.bialgenieapp.Fragments.Flights;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Adapters.FlightSearchAdapter;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentAllFlightsBinding;

import java.net.URL;
import java.util.ArrayList;


public class AllFlights extends Fragment {

    public AllFlights() {
        // Required empty public constructor
    }

    FragmentAllFlightsBinding binding;
    private String JsonResponseLink = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllFlightsBinding.inflate(getLayoutInflater());

        JsonResponseLink = getActivity().getIntent().getStringExtra("link");
        JsonResponseLink += "?directFlights=0";
        JsonResponseLink += "&limit=20";
        Log.i("AllFlights", JsonResponseLink);

        AllFlightAsyncTask task = new AllFlightAsyncTask();
        task.execute();

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<FSModel> flightInfo) {

        // bookList = booksInfos;

        if (flightInfo.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        FlightSearchAdapter flightAdapter = new FlightSearchAdapter(flightInfo, binding.recyclerViewArriving, getContext());
        binding.recyclerViewArriving.setAdapter(flightAdapter);
        binding.recyclerViewArriving.setLayoutManager(new LinearLayoutManager(getContext()));
        flightAdapter.notifyDataSetChanged();


    }

    private class AllFlightAsyncTask extends AsyncTask<URL, Void, ArrayList<FSModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<FSModel> doInBackground(URL... urls) {
            ArrayList<FSModel> event = FSQueryUtils.fetchFlightsData(JsonResponseLink);            //also we can use  urls[0]
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<FSModel> event) {

            binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                Log.i("AllFlights", "NULL EVENT");
                binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }

            updateUi(event);

        }

    }


}