package com.Hackathon.bialgenieapp.Database;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;



import com.Hackathon.bialgenieapp.Models.ParkingChargesData;
import com.azure.data.tables.TableClient;
import com.azure.data.tables.TableClientBuilder;
import com.azure.data.tables.TableServiceClient;
import com.azure.data.tables.TableServiceClientBuilder;
import com.azure.data.tables.models.TableEntity;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ParkingChargesDatabase {

    final static String tableName="Parking";
    static Context context;

    public static void createTable(Context context) throws IOException {



            ParkingChargesDatabase.context=context;
            String connectionString = getProperties(context);

            TableServiceClient tableServiceClient = new TableServiceClientBuilder()
                    .connectionString(connectionString)
                    .buildClient();

            TableClient tableClient = tableServiceClient.createTableIfNotExists(tableName);


    }
    public static void insertEntity(String carType,String date,String time) throws IOException {
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

        TableEntity user=new TableEntity(partitionKey,rowKey).setProperties(parkingInfo);

        tableClient.upsertEntity(user);
    }

    public static String getProperties(Context context) throws IOException {
        Properties properties=new Properties();
        AssetManager manager=context.getAssets();
        InputStream inputStream= manager.open("application.properties");
        properties.load(inputStream);
       return properties.getProperty("connectionString");
    }

}