package com.Hackathon.bialgenieapp.Database;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;


import androidx.annotation.RequiresApi;

import com.Hackathon.bialgenieapp.CalculateCharges;
import com.Hackathon.bialgenieapp.Fragments.Transit.CalculateTime;
import com.Hackathon.bialgenieapp.Fragments.Transit.TrackCharges;
import com.Hackathon.bialgenieapp.Models.ParkingChargesData;
import com.Hackathon.bialgenieapp.Models.ParkingDetails;
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.ListEntitiesOptions;
import com.azure.data.tables.models.TableEntity;
import com.azure.data.tables.models.TableEntityUpdateMode;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ParkingChargesDatabase {

    final static String tableName="Parking";
    final static String PARTITION_KEY = "PartitionKey";


    static int sum;
    static Context context;

    public static int getSum() {
        return sum;
    }


    public ParkingChargesDatabase(Context context){
        ParkingChargesDatabase.context=context;
    }

    public static void createTable(Context context) throws IOException {

            String connectionString = getProperties(context);

            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();

            TableClient tableClient = tableServiceClient.createTableIfNotExists(tableName);


    }
    public static void insertEntity(String carType,String date,String time,String elapsedTime) throws IOException {

        TableClient tableClient=new TableClientBuilder()
                .connectionString(getProperties(context))
                .tableName(tableName)
                .buildClient();

        String partitionKey="ParkingDetails";
        int number= (new Random()).nextInt(100);
        String rowKey=String.valueOf(number);
        Map<String,Object> parkingInfo=new HashMap<>();

        parkingInfo.put("CarType",carType);
        parkingInfo.put("Date",date);
        parkingInfo.put("Time",time);
        parkingInfo.put("ElapsedTime",elapsedTime);

        TableEntity user=new TableEntity(partitionKey,rowKey).setProperties(parkingInfo);

        tableClient.upsertEntity(user);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<ParkingDetails> getDetails() throws IOException {

        List<ParkingDetails> list=new ArrayList<>();

        String connectionString = getProperties(context);

        TableClient tableClient = new TableClientBuilder()
                .connectionString(connectionString)
                .tableName(tableName)
                .buildClient();

        ListEntitiesOptions options=new ListEntitiesOptions().setFilter(PARTITION_KEY+" eq 'ParkingDetails'");
        sum=0;

        tableClient.listEntities(options,null,null).forEach(tableEntity -> {
                list.add(new ParkingDetails(tableEntity.getProperty("Time").toString(),tableEntity.getProperty("Date").toString(),tableEntity.getProperty("ElapsedTime").toString(),tableEntity.getProperty("CarType").toString()));
            sum+=CalculateCharges.totalCharge(CalculateTime.getDays(),CalculateTime.getHours(),CalculateTime.getMin(),tableEntity.getProperty("CarType").toString(),context);
        });



        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void updateElapsedTime() throws IOException {

        String connectionString = getProperties(context);

        TableClient tableClient = new TableClientBuilder()
                .connectionString(connectionString)
                .tableName(tableName)
                .buildClient();

        // Get the specific entity.
        ListEntitiesOptions options=new ListEntitiesOptions().setFilter(PARTITION_KEY+" eq 'ParkingDetails'");

        tableClient.listEntities(options, null, null).forEach(tableEntity -> {

            //error occurs here--->
            /**
             *
             *
             *
             *
             */
            TableEntity specificEntity = tableClient.getEntity("ParkingDetails",tableEntity.getRowKey());

            try {
                CalculateTime.getTimeDiff(tableEntity.getProperty("Date").toString(),tableEntity.getProperty("Time").toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            specificEntity.getProperties().put("ElapsedTime",CalculateTime.getDays()+" days "+(CalculateTime.getHours())+" hours "+CalculateTime.getMin()+" mins ");
             sum+=CalculateCharges.totalCharge(CalculateTime.getDays(),CalculateTime.getHours(),CalculateTime.getMin(),tableEntity.getProperty("CarType").toString(),context);


            // Update the specific entity
            tableClient.updateEntity(specificEntity, TableEntityUpdateMode.REPLACE);
             });




    }

    public static String getProperties(Context context) throws IOException {
        Properties properties=new Properties();
        AssetManager manager=context.getAssets();
        InputStream inputStream= manager.open("application.properties");
        properties.load(inputStream);
       return properties.getProperty("connectionString");
    }

}