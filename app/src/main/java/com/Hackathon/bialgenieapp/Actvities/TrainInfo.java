package com.Hackathon.bialgenieapp.Actvities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;

import com.Hackathon.bialgenieapp.Adapters.TrainListAdapter;
import com.Hackathon.bialgenieapp.Models.TrainData;
import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.TrainAsyncTAsk;

import java.util.List;

public class TrainInfo extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<TrainData>> {

RecyclerView rv;
    Intent intent;
    String trainName;
    String trainNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_info);
        rv=findViewById(R.id.train_recycler_view);


        intent=getIntent();
        trainName=intent.getStringExtra("trainName");
        trainNumber=intent.getStringExtra("trainNumber");

        getLoaderManager().initLoader(0,null,this);

    }

    @Override
    public Loader<List<TrainData>> onCreateLoader(int i, Bundle bundle) {

        return new TrainAsyncTAsk(this,trainName,trainNumber);
    }

    @Override
    public void onLoadFinished(Loader<List<TrainData>> loader, List<TrainData> trainData) {
        updateUI(trainData);
    }

    private void updateUI(List<TrainData> trainData) {
        TrainListAdapter adapter=new TrainListAdapter(trainData,this,trainName);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<List<TrainData>> loader) {

    }
}