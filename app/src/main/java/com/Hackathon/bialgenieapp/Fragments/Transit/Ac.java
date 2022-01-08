package com.Hackathon.bialgenieapp.Fragments.Transit;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.R;


public class Ac extends Fragment {


    TextView meru1,mega1,ksrtc1,meruw,megaw,ksrtcw;
    AppCompatImageButton merug,ksrtcg,megag;



    public Ac() {
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
        View v = inflater.inflate(R.layout.fragment_women_taxi, container, false);
        meru1 = v.findViewById(R.id.meru1);
        ksrtc1 = v.findViewById(R.id.ksrtc1);
        mega1 = v.findViewById(R.id.mega1);
        merug = v.findViewById(R.id.merug);
        /* ksrtcg = v.findViewById(R.id.ksrtcg);*/
        megag = v.findViewById(R.id.megag);
        meruw = v.findViewById(R.id.meruw);
        megaw = v.findViewById(R.id.megaw);
        ksrtcw = v.findViewById(R.id.ksrtcw);



        meru1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ meru1.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        mega1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ mega1.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        ksrtc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:"+ ksrtc1.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });


        merug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.winit.merucab&hl=en_IN&gl=US")));
            }
        });
        megag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.megacabsvendor&hl=en_IN&gl=US")));
            }
        });
/*        ksrtcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.csipl.wtiapp&hl=en_IN&gl=US")));
            }
        });*/
        TextView linkTextView1 = v.findViewById(R.id.megaw);


        linkTextView1.setMovementMethod(LinkMovementMethod.getInstance());


        linkTextView1.setLinkTextColor(Color.BLUE);

        TextView linkTextView2 = v.findViewById(R.id.meruw);


        linkTextView2.setMovementMethod(LinkMovementMethod.getInstance());


        linkTextView2.setLinkTextColor(Color.BLUE);

        TextView linkTextView3 = v.findViewById(R.id.ksrtcw);


        linkTextView3.setMovementMethod(LinkMovementMethod.getInstance());


        linkTextView3.setLinkTextColor(Color.BLUE);
        return v;
    }
}