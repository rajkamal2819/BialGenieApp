package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Hackathon.bialgenieapp.Adapters.ParkingListChargesAdapter;
import com.Hackathon.bialgenieapp.Models.ParkingChargesData;
import com.Hackathon.bialgenieapp.R;

import java.util.ArrayList;
import java.util.List;


public class ChargesFragment extends Fragment {


    List<ParkingChargesData> headingsList=new ArrayList<>();
    RecyclerView rv;

    public ChargesFragment() {
        super(R.layout.fragment_charges);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_charges, container, false);

        headingsList.add(new ParkingChargesData("P4: Two Wheeler Parking",getString(R.string.lTitle),getString(R.string.rTitle),getString(R.string.t1),getString(R.string.t2),getString(R.string.t3),getString(R.string.t4),getString(R.string.t5),"40","20","250","150","250"));
        headingsList.add(new ParkingChargesData("P4: Car Parking",getString(R.string.lTitle),getString(R.string.rTitle),"0 to 30 mins",getString(R.string.t2),getString(R.string.t3),getString(R.string.t4),getString(R.string.t5),"100","50","600","350","600"));
        headingsList.add(new ParkingChargesData("P4: Parking for reduced mobility",getString(R.string.lTitle),getString(R.string.rTitle),"0 to 30 mins",getString(R.string.t2),getString(R.string.t3),getString(R.string.t4),getString(R.string.t5),"100","50","600","350","600"));
        headingsList.add(new ParkingChargesData("P4: Electric Car Parking","Location",getString(R.string.rTitle),getString(R.string.electricCarTitle),getString(R.string.fareElectricTitle),"","","","","","","",""));
        headingsList.add(new ParkingChargesData("P4: Bus Parking-Below 16 Sector",getString(R.string.lTitle),getString(R.string.rTitle),getString(R.string.t1),"Additional Hours",getString(R.string.t5),"","","200","200","1000","",""));
        headingsList.add(new ParkingChargesData("P4: Bus Parking-Above 16 Sector",getString(R.string.lTitle),getString(R.string.rTitle),getString(R.string.t1),"Additional Hours",getString(R.string.t5),"","","500","500","1000","",""));

        rv=view.findViewById(R.id.charges_recycler_view);
        ParkingListChargesAdapter adapter=new ParkingListChargesAdapter(headingsList,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);

        return view;


    }
}