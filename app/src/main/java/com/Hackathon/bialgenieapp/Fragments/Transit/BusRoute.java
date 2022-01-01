package com.Hackathon.bialgenieapp.Fragments.Transit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.R;
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.data.tables.models.TableEntity;

public class BusRoute extends AppCompatActivity {
    Intent i;
    String route,routea,routeb;
    TextView t_origin1, t_destination1, t_fare1, t_distance1, t_noofstops1,t_tt1,t_stops1,t_title1,t_title2;
    TextView t_origin2, t_destination2, t_fare2, t_distance2, t_noofstops2,t_tt2,t_stops2;
    public final String connectionString =
            "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route);
        route = getIntent().getStringExtra("route");
        routea = route+"A";
        t_title1 = findViewById(R.id.route1);
        t_destination1 = findViewById(R.id.edt_Destination1);
        t_fare1 = findViewById(R.id.edt_Fare1);
        t_distance1 = findViewById(R.id.edt_Distance1);
        t_origin1 = findViewById(R.id.edt_Origin1);
        t_noofstops1 = findViewById(R.id.edt_Stopsno1);
        t_tt1 = findViewById(R.id.edt_Timetable1);
        t_stops1 = findViewById(R.id.edt_Stops1);
        gettable(routea,1);

        routeb = route+"B";
        t_title2 = findViewById(R.id.route2);
        t_destination2 = findViewById(R.id.edt_Destination2);
        t_fare2 = findViewById(R.id.edt_Fare2);
        t_distance2 = findViewById(R.id.edt_Distance2);
        t_origin2 = findViewById(R.id.edt_Origin2);
        t_noofstops2 = findViewById(R.id.edt_Stopsno2);
        t_tt2 = findViewById(R.id.edt_Timetable2);
        t_stops2 = findViewById(R.id.edt_Stops2);
        gettable(routeb,2);
        t_title1.setText(route);
        t_title2.setText(route);


    }

    void gettable(String route,int c) {
        try {
            // Define constants for filters.
            final String PARTITION_KEY = route;
            final String ROW_KEY = "0001";
            final String tableName = "Bus";

            // Create a TableServiceClient with a connection string.
            // Create a TableClient with a connection string and a table name.
            TableClient tableClient = new TableClientBuilder()
                    .connectionString(connectionString)
                    .tableName(tableName)
                    .buildClient();

            TableEntity specificEntity = tableClient.getEntity(route, "0001");

            // Output the entity.
            if (c == 1) {
                if (specificEntity != null) {
                    t_origin1.setText(specificEntity.getProperty("Origin").toString());
                    t_destination1.setText(specificEntity.getProperty("Destination").toString());
                    t_fare1.setText(specificEntity.getProperty("Fare").toString());
                    t_noofstops1.setText(specificEntity.getProperty("Stopsno").toString());
                    t_distance1.setText(specificEntity.getProperty("Distance").toString());
                    t_tt1.setText(specificEntity.getProperty("timetable").toString());
                    t_stops1.setText(specificEntity.getProperty("stops").toString());

                }
            } else if (c == 2) {
                if (specificEntity != null) {
                    t_origin2.setText(specificEntity.getProperty("Origin").toString());
                    t_destination2.setText(specificEntity.getProperty("Destination").toString());
                    t_fare2.setText(specificEntity.getProperty("Fare").toString());
                    t_noofstops2.setText(specificEntity.getProperty("Stopsno").toString());
                    t_distance2.setText(specificEntity.getProperty("Distance").toString());
                    t_tt2.setText(specificEntity.getProperty("timetable").toString());
                    t_stops2.setText(specificEntity.getProperty("stops").toString());


                }

            }
        }
            catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}