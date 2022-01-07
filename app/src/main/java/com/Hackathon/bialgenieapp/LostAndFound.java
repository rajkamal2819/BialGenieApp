package com.Hackathon.bialgenieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.Hackathon.bialgenieapp.Fragments.Transit.TrackCharges;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class LostAndFound extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public String from,to,item,location,description,name,mobile,email,flightno,date,terminal;
    TextInputLayout t_item,t_location,t_description,t_name,t_mobile,t_email,t_flightno,t_terminal;
    Button submit,t_from,t_to,t_date;
    Calendar c=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener one;
 /*   public static final String datePicker1 = "datePicker1";
    public static final String datePicker2 = "datePicker2";
    public static final String datePicker3 = "datePicker3";
    public int mYear1;
    public int mMonth1;
    public int mDay1;
    public int mYear2;
    public int mMonth2;
    public int mDay2;
    public int mYear3;
    public int mMonth3;
    public int mDay3;
*/
  public int c1 = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_found);
        t_from = findViewById(R.id.from);
        t_to = findViewById(R.id.to);
        t_item = findViewById(R.id.item);
        t_location = findViewById(R.id.location);
        t_description= findViewById(R.id.itemdescription);
        t_flightno = findViewById(R.id.flightno);
        t_date = findViewById(R.id.date);
        t_name = findViewById(R.id.name);
        t_mobile = findViewById(R.id.mobile);
        t_email = findViewById(R.id.email);
        t_description = findViewById(R.id.itemdescription);
        t_terminal = findViewById(R.id.terminal);
        submit = findViewById(R.id.submit);
        t_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                c1=0;
                new DatePickerDialog(LostAndFound.this,(DatePickerDialog.OnDateSetListener) LostAndFound.this,year,month,day).show();

            }
        });
        t_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                c1=1;
                new DatePickerDialog(LostAndFound.this,(DatePickerDialog.OnDateSetListener) LostAndFound.this,year,month,day).show();

            }
        });
        t_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day=c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);
                c1=2;
                new DatePickerDialog(LostAndFound.this,(DatePickerDialog.OnDateSetListener) LostAndFound.this,year,month,day).show();

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                from = t_from.getText().toString();
                to = t_to.getText().toString();
                item = t_item.getEditText().getText().toString();
                location = t_location.getEditText().getText().toString();
                description = t_description.getEditText().getText().toString();

                name= t_name.getEditText().getText().toString();
                mobile = t_mobile.getEditText().getText().toString();
                email = t_email.getEditText().getText().toString();
                flightno = t_flightno.getEditText().getText().toString();
                date = t_date.getText().toString();
                terminal = t_terminal.getEditText().getText().toString();
                String d = "\tItem Description:\n\n"+"From : "+from+"\n"+"To : "+to+"\n"+"Item : "+item+"\n"+"Description : "+description+"\n"+"\n"
                        +"\tPassenger Information:\n\n"+"Name : "+name+"\n"+"Mobile : "+mobile+"\n"+"Email : "+email+"\n"+"\n"+
                        "\tFlight Details:\n\n"+"Flight number : "+flightno+"\n"+"Date of Travel : "+date+"\n"+"Terminal : "+terminal+"\n";
                Intent mailIntent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:?subject=" + "Claim of an Lost Item"+ "&body=" + d + "&to=" + "deniedaccess88@gmail.com");
                mailIntent.setData(data);
                startActivity(Intent.createChooser(mailIntent, "Send mail..."));

            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        if(c1==0)
        {
            t_from.setText(day+"/"+month+1+"/"+year);

        }
        else if(c1==1)
        {
            t_to.setText(day+"/"+month+1+"/"+year);

        }
        else if(c1==2)
        {
            t_date.setText(day+"/"+month+1+"/"+year);
        }


    }
}

