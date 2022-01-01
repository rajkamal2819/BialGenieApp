package com.Hackathon.bialgenieapp.Fragments.Transit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.Hackathon.bialgenieapp.R;
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.models.TableEntity;

public class Fly_City extends AppCompatActivity {

    String route,routea,routeb;
    TextView t_origin1, t_destination1,  t_distance1,t_tt1,t_title1,t_title2;
    TextView t_origin2, t_destination2,  t_distance2,t_tt2;
    public final String connectionString =
            "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fly_city);

        route = getIntent().getStringExtra("route");
        routea = route+"A";
        t_title1 = findViewById(R.id.title1f);
        t_destination1 = findViewById(R.id.edt_Destination1f);

        t_distance1 = findViewById(R.id.edt_Distance1f);
        t_origin1 = findViewById(R.id.edt_Origin1f);

        t_tt1 = findViewById(R.id.edt_Timetable1f);

        gettable(routea,1);

        routeb = route+"B";
        t_title2 = findViewById(R.id.title2f);
        t_destination2 = findViewById(R.id.edt_Destination2f);

        t_distance2 = findViewById(R.id.edt_Distance2f);
        t_origin2 = findViewById(R.id.edt_Origin2f);

        t_tt2 = findViewById(R.id.edt_Timetable2f);

        gettable(routeb,2);

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
                    t_origin1.setText(specificEntity.getProperty("origin").toString());
                    t_destination1.setText(specificEntity.getProperty("destination").toString());
                    t_title1.setText(specificEntity.getProperty("title").toString());
                    t_distance1.setText(specificEntity.getProperty("distance").toString());
                    t_tt1.setText(specificEntity.getProperty("timetable").toString());


                }
            } else if (c == 2) {
                if (specificEntity != null) {
                    t_origin2.setText(specificEntity.getProperty("origin").toString());
                    t_destination2.setText(specificEntity.getProperty("destination").toString());
                    t_title2.setText(specificEntity.getProperty("title").toString());
                    t_distance2.setText(specificEntity.getProperty("distance").toString());
                    t_tt2.setText(specificEntity.getProperty("timetable").toString());


                }

            }
        }
        catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}