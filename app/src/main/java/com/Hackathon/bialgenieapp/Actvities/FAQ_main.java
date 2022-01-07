package com.Hackathon.bialgenieapp.Actvities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.Hackathon.bialgenieapp.Adapters.FAQ_Adapter;
import com.Hackathon.bialgenieapp.Database.FAQ_table;
import com.Hackathon.bialgenieapp.Fragments.FAQ.faq_covid;
import com.Hackathon.bialgenieapp.Fragments.FAQ.faq_general;
import com.Hackathon.bialgenieapp.Fragments.FAQ.faq_others;
import com.Hackathon.bialgenieapp.Models.FAQ_Model;
import com.Hackathon.bialgenieapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FAQ_main extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<FAQ_Model> FAQ_Holder;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"terminalmanager@bialairport.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });



        BottomNavigationView bottomNavigationView = findViewById(R.id.menubar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.faq_frame,new faq_general()).commit();

//        recyclerView = findViewById(R.id.FAQ_ReView);
//        FAQ_Holder = new ArrayList<>();
//
//        initdata();
//        setrecyclerView();

        
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.general:
                    selectedFragment = new faq_general();
                    break;

                case R.id.covid:
                    selectedFragment = new faq_covid();
                    break;

                case R.id.others:
                    selectedFragment = new faq_others();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.faq_frame,selectedFragment).commit();
            return true;
        }
    };




    private void setrecyclerView() {
        FAQ_Adapter faq_adapter = new FAQ_Adapter(FAQ_Holder);
        recyclerView.setAdapter(faq_adapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initdata() {


        FAQ_Model ob6 = new FAQ_Model("Question4","Answer");
        FAQ_Model ob5 = new FAQ_Model("Question4","Answer");
        FAQ_Model ob4 = new FAQ_Model("Question4","Answer");
        FAQ_Model ob3 = new FAQ_Model("Question4","Answer");
        FAQ_Model ob2 = new FAQ_Model("Question4","Answer");
        FAQ_Model ob1 = new FAQ_Model("Question4","Answer");
        FAQ_Model ob0 = new FAQ_Model("Question4","Answer");
        FAQ_Holder.add(ob6);
        FAQ_Holder.add(ob5);
        FAQ_Holder.add(ob4);
        FAQ_Holder.add(ob3);
        FAQ_Holder.add(ob2);
        FAQ_Holder.add(ob1);


    }
}