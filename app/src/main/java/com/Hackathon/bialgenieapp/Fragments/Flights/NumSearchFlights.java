package com.Hackathon.bialgenieapp.Fragments.Flights;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.FlightDetailsActivity2;
import com.Hackathon.bialgenieapp.databinding.FragmentNumSearchFlightsBinding;

import java.util.Calendar;


public class NumSearchFlights extends Fragment {


    public NumSearchFlights() {
        // Required empty public constructor
    }

    FragmentNumSearchFlightsBinding binding;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    private String flightDate = "";
    private String jsonStart = "https://api.lufthansa.com/v1/operations/schedules/";
    private String temp = "https://api.lufthansa.com/v1/operations/schedules/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNumSearchFlightsBinding.inflate(getLayoutInflater());

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);

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
                String mm = month + "";
                String dd = dayOfMonth + "";
                String yy = year + "";
                if(month/10==0)
                    mm = "0"+mm;
                if(dayOfMonth/10==0)
                    dd = "0"+dd;
                String date = yy+"/"+mm+"/"+dd;
                binding.dateFormat.setText(date);
                flightDate = date;
            }
        };

        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(binding.search.getText())) {
                    Intent i = new Intent(getContext(), FlightDetailsActivity2.class);
                    String linkStart = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/flight/status/";
                    linkStart += binding.flightFsCode.getText().toString() + "/" + binding.flightNumber.getText().toString() + "/" + "dep/";

                    String dt = binding.dateFormat.getText().toString();

                    linkStart += dt + "?appId=d5828495&appKey=694ea86653f38f22a40aca0d6f941543&utc=false";
                    i.putExtra("linkFlight", linkStart);
                    Log.i("FlightStopAdapter",linkStart);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                } else{
                    Toast.makeText(getContext(),"Please fill required blocks",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }


}