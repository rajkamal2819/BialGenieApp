package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.Hackathon.bialgenieapp.Database.ParkingChargesDatabase;
import com.Hackathon.bialgenieapp.Models.ParkingChargesData;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import org.apache.log4j.lf5.viewer.TrackingAdjustmentListener;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;


public class TrackCharges extends Fragment implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    Spinner spinner;


    Button dateButton;
    Button timeButton;
    Button submitButton;
    MaterialDatePicker datePicker;
    Calendar c=Calendar.getInstance();
    String date="";
    int timeHour=0;
    int timeMinute=0;

    public TrackCharges() {
        super(R.layout.fragment_track_charges);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_track_charges, container, false);
        spinner=view.findViewById(R.id.spinner);
        dateButton=view.findViewById(R.id.date_button);
        timeButton=view.findViewById(R.id.time_button);
        submitButton=view.findViewById(R.id.submit_button);

        //ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.parking_type, android.R.layout.simple_spinner_item);

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(adapter);

//        datePicker=MaterialDatePicker.Builder.datePicker()
//                        .setTitleText("Select Dates")
//                        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
//                        .setTheme(R.style.Theme_BialGenieApp)
//                        .build();




        spinner.setOnItemSelectedListener(this);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int day=c.get(Calendar.DAY_OF_MONTH);
               int month=c.get(Calendar.MONTH);
               int year=c.get(Calendar.YEAR);

               new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) TrackCharges.this,year,month,day).show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hour=c.get(Calendar.HOUR_OF_DAY);
                int min=c.get(Calendar.MINUTE);
               new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) TrackCharges.this,hour,min, DateFormat.is24HourFormat(getContext())).show();

            }
        });



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ParkingChargesDatabase.creteTable();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });






        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    public void onTimeSet(TimePicker timePicker, int timeHour, int timeMinute) {

        timeButton.setText(CalculateTime.getTimeFormat(timeHour,timeMinute));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        dateButton.setText(day+"/"+month+"/"+year);
    }
}