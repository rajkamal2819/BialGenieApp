package com.Hackathon.bialgenieapp.Fragments.Flights;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.DatePicker;

import com.Hackathon.bialgenieapp.Adapters.FlightItemAdapter;
import com.Hackathon.bialgenieapp.FromToFlightResults;
import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Models.FSModel;
import com.Hackathon.bialgenieapp.Queries.ArrDepQueryUtils;
import com.Hackathon.bialgenieapp.Queries.FSQueryUtils;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentFromToFlightsBinding;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;


public class FromToFlights extends Fragment {

    public FromToFlights() {
        // Required empty public constructor
    }

    FragmentFromToFlightsBinding binding;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    private String flightDate = "";
    private String JsonResponseLink = "https://api.lufthansa.com/v1/operations/schedules/BLR/CDG/2021-12-17?directFlights=0";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFromToFlightsBinding.inflate(getLayoutInflater());

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);

        ArrivalAsyncTask task = new ArrivalAsyncTask();
        task.execute();

        binding.dateFormat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener,year,month,day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = year+"-"+month+"-"+dayOfMonth;
                binding.dateFormat.setText(date);
                flightDate = date;
            }
        };

        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), FromToFlightResults.class));
            }
        });

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<FSModel> flightInfo) {

        // bookList = booksInfos;

        /*CoursesItemAdapter sliderAdapter = new CoursesItemAdapter(booksInfos, binding.recyclerView, getApplicationContext(), R.layout.courses_item_specific, 2);
        binding.recyclerView.setAdapter(sliderAdapter);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));*/

       /* FlightItemAdapter flightAdapter = new FlightItemAdapter(flightInfo,binding.recyclerViewArriving,getContext(),1);
        binding.recyclerViewArriving.setAdapter(flightAdapter);
        binding.recyclerViewArriving.setLayoutManager(new LinearLayoutManager(getContext()));
        flightAdapter.notifyDataSetChanged();*/



        //  binding.textView3.setText(booksInfos.get(0).getAirportArrivalInformation().getAirportName()+"");

    }

    private class ArrivalAsyncTask extends AsyncTask<URL, Void, ArrayList<FSModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<FSModel> doInBackground(URL... urls) {
            ArrayList<FSModel> event = FSQueryUtils.fetchFlightsData(JsonResponseLink);            //also we can use  urls[0]
            Log.i("CategoryCoursesActivity", JsonResponseLink);
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<FSModel> event) {

          //  binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                //  binding.emptyNoBook.setText("No Books Found");
                return;
            }

            updateUi(event);

        }

    }


}