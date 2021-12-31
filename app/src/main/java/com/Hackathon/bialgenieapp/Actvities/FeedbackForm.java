package com.Hackathon.bialgenieapp.Actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatEditText;

import android.widget.EditText;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.Fragments.Transit.BusRoute;
import com.Hackathon.bialgenieapp.R;

import java.util.Collections;

public class FeedbackForm extends AppCompatActivity {
    String type,category,fn,ln,age,gender,phone,email,airline,flightno,description,nationality;
    EditText t_type,t_category,t_fn,t_ln,t_age,t_gender,t_phone,t_email,t_airline,t_flightno,t_description;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
       submit = findViewById(R.id.submit_feedback);
        t_type = findViewById(R.id.actv_type);
        t_category = findViewById(R.id.actv_category);
        t_gender = findViewById(R.id.actv_gender);
        t_age = findViewById(R.id.edt_age);
        t_airline= findViewById(R.id.edt_airline);
        t_flightno = findViewById(R.id.edt_flightnumber);
        t_fn = findViewById(R.id.edt_fn);
        t_ln = findViewById(R.id.edt_ln);
        t_phone = findViewById(R.id.edt_phone);
        t_email = findViewById(R.id.edt_email);
        t_description = findViewById(R.id.edt_description);





        ArrayAdapter<String> genderadapter = new ArrayAdapter<String>(this,R.layout.bus_selector_item,getResources().getStringArray(R.array.Gender));
        AutoCompleteTextView actv_gender = findViewById(R.id.actv_gender);
        actv_gender.setAdapter(genderadapter);
        actv_gender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                gender = adapterView.getItemAtPosition(i).toString();
            }
        });

        ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this,R.layout.bus_selector_item, getResources().getStringArray(R.array.type));
        AutoCompleteTextView actv_type = findViewById(R.id.actv_type);
        actv_type.setAdapter(typeadapter);
        actv_type.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                type = adapterView.getItemAtPosition(i).toString();
            }
        });

        ArrayAdapter<String> typecategory = new ArrayAdapter<String>(this,R.layout.bus_selector_item, getResources().getStringArray(R.array.Category));
        AutoCompleteTextView actv_category = findViewById(R.id.actv_category);
        actv_category.setAdapter(typecategory);
        actv_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                category = adapterView.getItemAtPosition(i).toString();
            }
        });
        String a = "name"+gender;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = t_type.getText().toString();
                category = t_category.getText().toString();
                fn = t_fn.getText().toString();
                ln = t_ln.getText().toString();
                age = t_age.getText().toString();

                phone= t_phone.getText().toString();
                email = t_email.getText().toString();
                airline = t_airline.getText().toString();
                flightno = t_flightno.getText().toString();
                description = t_description.getText().toString();
                String d = "Name:"+fn+" "+ln+"\n"+"Gender:"+gender+"\n"+"Age:"+age+"\n"+"Type:"+type+"\n"+"Category:"+category+"\n"+"Phone:"+phone+"\n"+"Email:"+email+"\n"+"Airline:"+airline+"\n"+"Flight Number:"+flightno+"\n"+"Issue:"+description;
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "Feedback"+ "&body=" + d + "&to=" + "deniedaccess88@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));

            }
        });
    }


}