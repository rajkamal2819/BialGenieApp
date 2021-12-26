package com.Hackathon.bialgenieapp.Fragments.Transit;



import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Hackathon.bialgenieapp.R;
import com.Hackathon.bialgenieapp.TrainInfo;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


public class Transit_Train extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText trainName,trainNumber;
    Button submitButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transit__train);

        trainName=findViewById(R.id.train_name_text_enter);
        trainNumber=findViewById(R.id.train_number_text_enter);
        submitButton=findViewById(R.id.submit_button);

        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String trainNameStr=trainName.getText().toString();
        String trainNumStr=trainNumber.getText().toString();

        if (trainNameStr.isEmpty() && trainNumStr.isEmpty()){
            Snackbar.make(view,"Please enter any one field",Snackbar.LENGTH_SHORT).show();
            return;
        }

        Intent intent=new Intent(this, TrainInfo.class);
        intent.putExtra("trainName",trainNameStr);
        intent.putExtra("trainNum",trainNumStr);

        startActivity(intent);

    }
}