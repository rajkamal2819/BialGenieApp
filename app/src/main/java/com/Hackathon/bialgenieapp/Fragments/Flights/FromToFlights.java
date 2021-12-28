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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Actvities.FlightAcitivities.FromToFlightResults;
import com.Hackathon.bialgenieapp.databinding.FragmentFromToFlightsBinding;

import java.util.Calendar;


public class FromToFlights extends Fragment {

    public FromToFlights() {
        // Required empty public constructor
    }

    FragmentFromToFlightsBinding binding;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    private String flightDate = "";
    private String jsonStart = "https://api.lufthansa.com/v1/operations/schedules/";
    private String temp = "https://api.lufthansa.com/v1/operations/schedules/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFromToFlightsBinding.inflate(getLayoutInflater());

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
                String date = year+"-"+month+"-"+dayOfMonth;
                binding.dateFormat.setText(date);
                flightDate = date;
            }
        };

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(binding.dstEdittext.getText())&&!TextUtils.isEmpty(binding.fromEdittext.getText())) {
                    jsonStart = temp;
                    jsonStart += binding.fromEdittext.getText().toString().trim() + "/";
                    jsonStart += binding.dstEdittext.getText().toString().trim() + "/";
                    jsonStart += flightDate;

                    Intent i = new Intent(getContext(), FromToFlightResults.class);
                    i.putExtra("link", jsonStart);
                    startActivity(i);
                } else{
                    Toast.makeText(getContext(),"Please fill required blocks",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }

}