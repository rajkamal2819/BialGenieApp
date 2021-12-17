package com.Hackathon.bialgenieapp.Queries;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.Hackathon.bialgenieapp.Models.ArDepModel;
import com.Hackathon.bialgenieapp.Models.FSModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class FSQueryUtils {

    private static String LOG_TAG = FSQueryUtils.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<FSModel> fetchFlightsData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);         //makeHttpRequest is taking url object
            Log.i(LOG_TAG, "JsonResponse had been taken by httpReq");
        } catch (IOException e) {
            Log.i(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create an {@link Event} object
        ArrayList<FSModel> apDepInfo = extractFeatureFromJson(jsonResponse);

        // Return the {@link Event}
        return apDepInfo;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
            Log.i(LOG_TAG, "Successfully Url object created");
        } catch (MalformedURLException e) {
            Log.i(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            // String clientId = "3d44123a";
             String accessToken = "8wuwu93ymc2f2f7ugn96kgnt";

           /* byte[] loginBytes = (accessToken).getBytes();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Basic ")
                    .append(Base64.encodeToString(loginBytes,Base64.NO_WRAP));

            urlConnection.setRequestProperty("Authorization",stringBuilder.toString());*/

            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer pzkpkchh2xvffuqcaw2vanmd");

            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setDoInput(true);

            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
                Log.i(LOG_TAG, "Http Request Successfully initiated");
            } else {
                Log.i(LOG_TAG, "Header: " + urlConnection.getHeaderField("Authorization"));
                Log.i(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.i(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
            Log.i(LOG_TAG, e.getMessage());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        Log.i(LOG_TAG, "Reading from Stream");
        Log.d(LOG_TAG, output.toString());
        return output.toString();
    }

    private static ArrayList<FSModel> extractFeatureFromJson(String jsonResponse) {
        // If the JSON string is empty or null, then return early.
        ArrayList<FSModel> fsList = new ArrayList<>();
        if (TextUtils.isEmpty(jsonResponse)) {
            return fsList;
        }

        try {

              JSONObject mainObj = new JSONObject(jsonResponse);

            return fsList;
        } catch (JSONException e) {
            Log.i(LOG_TAG, "Problem parsing the JSON results", e);
        }
        return fsList;

    }
 }