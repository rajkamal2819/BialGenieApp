package com.Hackathon.bialgenieapp.Fragments.Transit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.R;

public class CarRentals extends Fragment {
    TextView wti1,wti2,wti3,wtiw,car1,car2,car3,carw;
    AppCompatImageButton wtig,carg;

    public CarRentals() {
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
        View v = inflater.inflate(R.layout.activity_car_rentals, container, false);
        wti1 = v.findViewById(R.id.wti1);
        wti2 = v.findViewById(R.id.wti2);
        wtiw = v.findViewById(R.id.wtiw);
        wtig = v.findViewById(R.id.wtig);
        car1 = v.findViewById(R.id.car1);
        car2 = v.findViewById(R.id.car2);
        car3 = v.findViewById(R.id.car3);
        carw = v.findViewById(R.id.carw);
        carg = v.findViewById(R.id.carg);


       wti1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Uri number = Uri.parse("tel:"+ wti1.getText());
               Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
               startActivity(callIntent);
           }
       });
        wti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ wti2.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ car1.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ car2.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
        car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ car3.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });
        carg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=carzonrent.crdapp&hl=en_IN&gl=US")));

            }
        });
        wtig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.csipl.wtiapp&hl=en_IN&gl=US")));
            }
        });
        TextView linkTextView = v.findViewById(R.id.wtiw);


        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());


        linkTextView.setLinkTextColor(Color.BLUE);

        TextView linkTextView1 = v.findViewById(R.id.carw);


        linkTextView1.setMovementMethod(LinkMovementMethod.getInstance());


        linkTextView1.setLinkTextColor(Color.BLUE);

    return v;

    }
}