package com.Hackathon.bialgenieapp.Database;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import com.Hackathon.bialgenieapp.Models.ParkingChargesData;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class ParkingChargesDatabase {


   static String url="jdbc:sqlserver://bialserver.database.windows.net:1433;"+"database=BialHackathonDatabase;"+"user=azureuser@bialserver;"+"password=AccessDenied123;"+"encrypt=true;"+"trustServerCertificate=false;"+"hostNameInCertificate=*.database.windows.net;"+"loginTimeout=30;";


    public static void creteTable() throws IOException, SQLException, ClassNotFoundException {

//        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
       new ConnectAsyncTask().execute();



//        Connection connection= DriverManager.getConnection(url);


    }

    public static class ConnectAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try (Connection connection = DriverManager.getConnection(url)) {
                Log.i("TAG","Success connecting");
            }
            // Handle any errors that may have occurred.
            catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
//
}