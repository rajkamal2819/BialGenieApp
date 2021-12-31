package com.Hackathon.bialgenieapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.Fragments.Transit.BusRoute;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;
import java.util.List;


public class TransitBusVV extends Fragment implements AdapterView.OnItemClickListener{
    //arrivals in list and in textview
    Spinner spn;
    Button btn;
    View v;
    String routeselected;



    public TransitBusVV() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_transit_bus_v_v, container, false);

      /*  spn = v.findViewById(R.id.spinner2);*/
        btn = v.findViewById(R.id.btn);
      String[] routes = getResources().getStringArray(R.array.routes);
     ArrayAdapter<String> routeadapter = new ArrayAdapter<String>(getContext(),R.layout.bus_selector_item,routes);
        AutoCompleteTextView autocompletetextview = v.findViewById(R.id.autoCompleteTextView);
       autocompletetextview.setAdapter(routeadapter);
       autocompletetextview.setOnItemClickListener(this::onItemClick);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getContext(), BusRoute.class);
               i.putExtra("route",routeselected);
               startActivity(i);
           }
       });

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
         routeselected = adapterView.getItemAtPosition(i).toString();


    }
}