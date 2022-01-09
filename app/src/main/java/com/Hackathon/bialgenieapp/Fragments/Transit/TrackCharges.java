package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.Hackathon.bialgenieapp.Actvities.Transit_Parking;
import com.Hackathon.bialgenieapp.Database.ParkingChargesDatabase;
import com.Hackathon.bialgenieapp.Models.ParkingChargesData;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.StorageAsyncTask;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import org.apache.log4j.lf5.viewer.TrackingAdjustmentListener;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;


public class TrackCharges extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    Spinner spinner;


    Button dateButton;
    Button timeButton;
    Button submitButton;
    String carType="";
    MaterialDatePicker datePicker;
    Calendar c=Calendar.getInstance();
    static String date="";
    static String time="";
    String elapsedTime="";

    public static String getDate() {
        return date;
    }

    public static String getTime() {
        return time;
    }

    public TrackCharges() {
        super(R.layout.fragment_track_charges);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        spinner=findViewById(R.id.spinner);
        dateButton=findViewById(R.id.date_button);
        timeButton=findViewById(R.id.time_button);
        submitButton=findViewById(R.id.submit_button);


        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.car_type, android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);

                new DatePickerDialog(TrackCharges.this,(DatePickerDialog.OnDateSetListener) TrackCharges.this,year,month,day).show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hour=c.get(Calendar.HOUR_OF_DAY);
                int min=c.get(Calendar.MINUTE);
                new TimePickerDialog(TrackCharges.this, (TimePickerDialog.OnTimeSetListener) TrackCharges.this,hour,min, DateFormat.is24HourFormat(TrackCharges.this)).show();

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                        ParkingChargesDatabase.createTable(TrackCharges.this);
                    CalculateTime.getTimeDiff(date,time);
                    int days= CalculateTime.getDays();
                    int hours=CalculateTime.getHours();
                    int min=CalculateTime.getMin();
                    elapsedTime=days+" days "+hours+" hours "+min+" mins ";
                    new StorageAsyncTask().execute(carType,date,time,elapsedTime);
                    startActivity(new Intent(TrackCharges.this,Transit_Parking.class));
                    finish();
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        carType= adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onTimeSet(TimePicker timePicker, int timeHour, int timeMinute) {
        Log.i("TIME CHECK",timeHour+" "+timeMinute);
        time=CalculateTime.getTimeFormat(timeHour,timeMinute);
        timeButton.setText(time);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        date=day+"/"+(month+1)+"/"+year;
        dateButton.setText(date);
    }
}