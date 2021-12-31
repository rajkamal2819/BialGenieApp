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
    String route;
    TextView t_origin, t_destination, t_fare, t_distance, t_noofstops;
    public final String connectionString =
            "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_route);
        route = getIntent().getStringExtra("route");
        route = route+"A";
        t_destination = findViewById(R.id.edt_destination);
        t_fare = findViewById(R.id.edt_fare);
        t_distance = findViewById(R.id.edt_distance);
        t_origin = findViewById(R.id.edt_origin);
        t_noofstops = findViewById(R.id.edt_noofstops);
        gettable();


    }

    void gettable() {
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
            if (specificEntity != null) {
                t_origin.setText(specificEntity.getProperty("Origin").toString());
                t_destination.setText(specificEntity.getProperty("Destination").toString());
                t_fare.setText(specificEntity.getProperty("Fare").toString());
                t_noofstops.setText(specificEntity.getProperty("Stopsno").toString());
                t_distance.setText(specificEntity.getProperty("Distance").toString());


            }

        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}