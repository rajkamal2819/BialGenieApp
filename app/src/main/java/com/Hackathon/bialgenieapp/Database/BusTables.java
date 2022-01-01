package com.Hackathon.bialgenieapp.Database;



import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.data.tables.models.TableEntity;
import com.azure.data.tables.models.TableEntityUpdateMode;
import com.azure.data.tables.models.TableTransactionAction;
import com.azure.data.tables.models.TableTransactionActionType;

import java.util.HashMap;
import java.util.Map;

public class BusTables {
    final String tableName = "Bus";
    // Define the connection-string with your values.
    public final String connectionString =
            "DefaultEndpointsProtocol=https;AccountName=bialtable;AccountKey=wRCVF2troxwyrE9pieQU0tjN84QSOwnq0ybCZBg+b76/EIUD3xFmM2p19Dn8hiIyKWGs1gPAm5cyKhHxh2y7oA==;EndpointSuffix=core.windows.net";
  public void create_Table()
   {

       try
       {


           // Create a TableServiceClient with a connection string.
           TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                   .connectionString(connectionString)
                   .buildClient();

           // Create the table if it not exists.
           TableClient tableClient = tableServiceClient.createTableIfNotExists(tableName);

       }
       catch (Exception e)
       {
           // Output the stack trace.
           e.printStackTrace();
       }
   }

   public void set_Values(String route,String origin, String destination, int stopsno, double dist,double fare)
   {
       try
       {


           // Create a TableClient with a connection string and a table name.
           TableClient tableClient = new TableClientBuilder()
                   .connectionString(connectionString)
                   .tableName(tableName)
                   .buildClient();

           // Create a new employee TableEntity.
           String partitionKey = route;
           String rowKey = "0001";
           Map<String, Object> basic= new HashMap<>();
           basic.put("Origin", origin);
           basic.put("Destination", destination);
           basic.put("Stopsno", stopsno);
           basic.put("Distance", dist);
           basic.put("Fare", fare);

           TableEntity bus = new TableEntity(partitionKey, rowKey).setProperties(basic);

           // Upsert the entity into the table
           tableClient.upsertEntity(bus);
       }
       catch (Exception e)
       {
           // Output the stack trace.
           e.printStackTrace();
       }
   }

   public void setArrivalDeparture(String route,String timetable,String stops) {

       try {


           // Create a TableClient with a connection string and a table name.
           TableClient tableClient = new TableClientBuilder()
                   .connectionString(connectionString)
                   .tableName(tableName)
                   .buildClient();

           // Create a new employee TableEntity.


           String partitionKey = route;
//arr-des starts from 0002 and remember 0009 and then 00010 so total frm 0001 to 000+count +2+1
           String rowKey = "0001";
           Map<String, Object> basic = new HashMap<>();
           basic.put("timetable", timetable);
           basic.put("stops", stops);
           TableEntity bus = new TableEntity(partitionKey, rowKey).setProperties(basic);

           // Upsert the entity into the table
           tableClient.upsertEntity(bus);
       }
       catch (Exception e)
       {
           // Output the stack trace.
           e.printStackTrace();
       }
   }

   public void set_city(String route,String title,String origin,String destination,String timetable,String distance)
   {

       try {


           // Create a TableClient with a connection string and a table name.
           TableClient tableClient = new TableClientBuilder()
                   .connectionString(connectionString)
                   .tableName(tableName)
                   .buildClient();

           // Create a new employee TableEntity.


           String partitionKey = route;
//arr-des starts from 0002 and remember 0009 and then 00010 so total frm 0001 to 000+count +2+1
           String rowKey = "0001";
           Map<String, Object> basic = new HashMap<>();
           basic.put("title", title);
           basic.put("origin", origin);
           basic.put("destination", destination);
           basic.put("distance", distance);
           basic.put("timetable", timetable);
           TableEntity bus = new TableEntity(partitionKey, rowKey).setProperties(basic);

           // Upsert the entity into the table
           tableClient.upsertEntity(bus);
       }
       catch (Exception e)
       {
           // Output the stack trace.
           e.printStackTrace();
       }

   }
       }


