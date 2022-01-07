package com.Hackathon.bialgenieapp.Fragments.hotels;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
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

import com.Hackathon.bialgenieapp.Actvities.Hotels.HotelSearchResults;
import com.Hackathon.bialgenieapp.Models.HotelsModel;
import com.Hackathon.bialgenieapp.Queries.HotelsQuery;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.databinding.FragmentSearchHotelsBinding;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;

public class SearchHotels extends Fragment {

    public SearchHotels() {
        // Required empty public constructor
    }

    FragmentSearchHotelsBinding binding;
    DatePickerDialog.OnDateSetListener onDateSetListener1;
    DatePickerDialog.OnDateSetListener onDateSetListener2;
    private String checkInDate = "" , checkOutDate = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchHotelsBinding.inflate(getLayoutInflater());

        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);

        binding.checkInFormat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener1,year,month,day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
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
                String date = yy+"-"+mm+"-"+dd;
                binding.checkInFormat.setText(date);
                checkInDate = date;
            }
        };

        final Calendar calendar2 = Calendar.getInstance();
        int year2 = calendar2.get(calendar2.YEAR);
        int month2 = calendar2.get(calendar2.MONTH);
        int day2 = calendar2.get(calendar2.DAY_OF_MONTH);

        binding.checkOutFormat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener2,year2,month2,day2);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        onDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
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
                String date = yy+"-"+mm+"-"+dd;
                binding.checkOutFormat.setText(date);
                checkOutDate = date;
            }
        };

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(binding.location.getText())||TextUtils.isEmpty(binding.numOfAdults.getText())){
                    Toast.makeText(getContext(),"Please Fill all the fields",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(getContext(), HotelSearchResults.class);
                    i.putExtra("location", binding.location.getText().toString());
                    i.putExtra("adults", binding.numOfAdults.getText().toString());
                    i.putExtra("checkInDate", checkInDate);
                    i.putExtra("checkOutDate", checkOutDate);
                    startActivity(i);
                }
            }
        });


        return binding.getRoot();
    }

}