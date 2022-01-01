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
import android.widget.ImageView;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Database.CreateBusTable;
import com.Hackathon.bialgenieapp.Fragments.Transit.BusRoute;
import com.Hackathon.bialgenieapp.Fragments.Transit.Fly_City;
import com.Hackathon.bialgenieapp.R;


public class TransitBusFly extends Fragment {
  View v;
    Button btn;
    ImageView change ;
    String routeselected;
    String temp1,temp2;
    public TransitBusFly() {
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
        v = inflater.inflate(R.layout.fragment_transit_bus_fly, container, false);

        change = v.findViewById(R.id.change);
        btn = v.findViewById(R.id.btn);
        /*CreateBusTable c = new CreateBusTable();
        c.set_city();*/
        String[] routes = getResources().getStringArray(R.array.Cities);
        ArrayAdapter<String> routeadapter = new ArrayAdapter<String>(getContext(),R.layout.bus_selector_item,routes);
        AutoCompleteTextView autocompletetextview1 = v.findViewById(R.id.autoCompleteTextViewf2);
        autocompletetextview1.setAdapter(routeadapter);
        autocompletetextview1.setOnItemClickListener(this::onItemClick);
       /* AutoCompleteTextView autocompletetextview2 = v.findViewById(R.id.autoCompleteTextViewf2);
        autocompletetextview2.setAdapter(routeadapter);
        autocompletetextview2.setOnItemClickListener(this::onItemClick);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp1 = autocompletetextview1.getText().toString();
                temp2 = autocompletetextview2.getText().toString();
                if(temp1 == "KIAL")
                {
                    Toast.makeText(getContext(),"temp1 = KIAL",Toast.LENGTH_LONG).show();
                    int safe = autocompletetextview1.getInputType();
                    autocompletetextview1.setInputType(safe);
                    autocompletetextview1.setText(temp2);
                    autocompletetextview2.setText(temp1);
                    autocompletetextview2.setInputType(0);
                    autocompletetextview1.setAdapter(routeadapter);

                }
                else
                {   autocompletetextview1.setText(temp2);
                    autocompletetextview1.setInputType(0);

                    int safe = autocompletetextview2.getInputType();
                    autocompletetextview2.setInputType(safe);
                    autocompletetextview2.setText(temp2);
                    autocompletetextview2.setAdapter(routeadapter);


                }
            }
        });*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), Fly_City.class);
               switch(routeselected)
               {
                   case "Kundapura" :
                       i.putExtra("route","10");
                       break;
                   case "Madikeri"   :
                       i.putExtra("route","20");
                       break;
                   case "Mysuru"   :
                       i.putExtra("route","30");
                       break;
               }
                startActivity(i);
            }
        });
        return v;
    }

    private void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

      routeselected = adapterView.getItemAtPosition(i).toString();
    }
}