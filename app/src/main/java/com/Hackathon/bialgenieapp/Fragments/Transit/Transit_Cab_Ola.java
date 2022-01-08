package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.R;


public class Transit_Cab_Ola extends Fragment {


    public Transit_Cab_Ola() {
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
        View v = inflater.inflate(R.layout.fragment_transit__cab__ola, container, false);
       /* r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        });*/


        Button b;
        b = v.findViewById(R.id.ridebutton1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.olacabs.customer&hl=en_IN&gl=US")));
            }
        });


        TextView linkTextView = v.findViewById(R.id.text3);


        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());


        linkTextView.setLinkTextColor(Color.BLUE);

        return v;


    }
}