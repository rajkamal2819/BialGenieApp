package com.Hackathon.bialgenieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Adapters.RouteAdapter;
import com.Hackathon.bialgenieapp.Database.Route_Model;

import java.util.ArrayList;

public class Route extends AppCompatActivity {

    private RecyclerView courseRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        courseRV = findViewById(R.id.idRVCourse);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Route_Model> object = (ArrayList<Route_Model>) args.getSerializable("ARRAYLIST");

        // here we have created new array list and added data to it.



        // we are initializing our adapter class and passing our arraylist to it.
        RouteAdapter courseAdapter = new RouteAdapter(this, object);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
    }


}
