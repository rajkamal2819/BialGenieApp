package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.Adapters.TrackChargesListAdapter;
import com.Hackathon.bialgenieapp.CalculateCharges;
import com.Hackathon.bialgenieapp.Database.ParkingChargesDatabase;
import com.Hackathon.bialgenieapp.Models.ParkingDetails;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.ReadAsyncTask;
import com.Hackathon.bialgenieapp.StorageAsyncTask;
import com.Hackathon.bialgenieapp.UpdateAsyncTask;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.graph.models.extensions.Shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class ParkingMainList extends Fragment {

    List<ParkingDetails> parkingDetailsList=new ArrayList<>();
    RecyclerView rv;


    public ParkingMainList() {
        // Required empty public constructor
        super(R.layout.fragment_parking_main_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parking_main_list, container, false);

        FloatingActionButton fab=view.findViewById(R.id.fab1);
        rv=view.findViewById(R.id.parking_main_list);
        TextView charges=view.findViewById(R.id.fare_price_text);





        new ParkingChargesDatabase(getContext());
        try {
              new UpdateAsyncTask().execute();
            //ParkingChargesDatabase.updateElapsedTime();
           parkingDetailsList=ParkingChargesDatabase.getDetails();


        } catch (IOException e) {
            e.printStackTrace();
        }

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new TrackChargesListAdapter(getContext(),parkingDetailsList));
        charges.setText(String.valueOf(ParkingChargesDatabase.getSum()));



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(getActivity(),TrackCharges.class));
            }
        });
        return view;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback() {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//            }
//        })
//    }
}