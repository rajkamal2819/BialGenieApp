package com.Hackathon.bialgenieapp.Queries;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

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
import java.lang.reflect.Array;
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
            // String accessToken = "55pxhuynzt8zmbj8pcuzd7j2";

           /* byte[] loginBytes = (accessToken).getBytes();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Basic ")
                    .append(Base64.encodeToString(loginBytes,Base64.NO_WRAP));

            urlConnection.setRequestProperty("Authorization",stringBuilder.toString());*/

            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Authorization", "Bearer 8uu9y3hs92p5sykekdtq8suy");

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
      //  Log.d(LOG_TAG, output.toString());
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
            JSONObject scheduleResource = mainObj.getJSONObject("ScheduleResource");
            JSONArray schedules = scheduleResource.getJSONArray("Schedule");

            for (int i = 0; i < schedules.length(); i++) {

                FSModel model = new FSModel();
                JSONObject cur = schedules.getJSONObject(i);
                if (cur.has("TotalJourney")) {
                    JSONObject TotalJourney = cur.getJSONObject("TotalJourney");
                    if (TotalJourney.has("Duration")) {
                        model.setTotalJourneyDuration(TotalJourney.getString("Duration"));
                    }
                }

                JSONArray Flight = cur.optJSONArray("Flight");
                ArrayList<FSModel.FlightSpots> flightSpots = new ArrayList<>();
                if (Flight != null) {
                    for (int j = 0; j < Flight.length(); j++) {

                        JSONObject curSpots = Flight.getJSONObject(j);
                        FSModel.FlightSpots spots = new FSModel.FlightSpots();

                        if (curSpots.has("Departure")) {
                            JSONObject Departure = curSpots.getJSONObject("Departure");
                            if (Departure.has("AirportCode")) {
                                spots.setDepartureAirport(Departure.getString("AirportCode"));
                            }
                            if (Departure.has("ScheduledTimeLocal")) {
                                JSONObject scheduleTime = Departure.getJSONObject("ScheduledTimeLocal");
                                if (scheduleTime.has("DateTime")) {
                                    spots.setDepartureTime(scheduleTime.getString("DateTime"));
                                }
                            }
                            if (Departure.has("Terminal")) {
                                JSONObject Terminal = Departure.getJSONObject("Terminal");
                                if (Terminal.has("Name")) {
                                    spots.setDepartureTerminal(Terminal.getString("Name"));
                                }
                            }
                        }

                        if (curSpots.has("Arrival")) {
                            JSONObject Arrival = curSpots.getJSONObject("Arrival");
                            if (Arrival.has("AirportCode")) {
                                spots.setArrivalAirport(Arrival.getString("AirportCode"));
                            }
                            if (Arrival.has("ScheduledTimeLocal")) {
                                JSONObject scheduleTime = Arrival.getJSONObject("ScheduledTimeLocal");
                                if (scheduleTime.has("DateTime")) {
                                    spots.setArrivalTime(scheduleTime.getString("DateTime"));
                                }
                            }
                            if (Arrival.has("Terminal")) {
                                JSONObject Terminal = Arrival.getJSONObject("Terminal");
                                if (Terminal.has("Name")) {
                                    spots.setArrivalTerminal(Terminal.getString("Name"));
                                }
                            }
                        }

                        if (curSpots.has("MarketingCarrier")) {
                            JSONObject MarketingCarrier = curSpots.getJSONObject("MarketingCarrier");
                            if (MarketingCarrier.has("AirlineID")) {
                                spots.setAirlines(MarketingCarrier.getString("AirlineID"));
                            }
                            if (MarketingCarrier.has("FlightNumber")) {
                                spots.setAirlineNumber(MarketingCarrier.getString("FlightNumber"));
                            }
                        }

                        flightSpots.add(spots);

                    }
                } else{
                    JSONObject singleFlight = cur.getJSONObject("Flight");

                    FSModel.FlightSpots spots = new FSModel.FlightSpots();

                    if (singleFlight.has("Departure")) {
                        JSONObject Departure = singleFlight.getJSONObject("Departure");
                        if (Departure.has("AirportCode")) {
                            spots.setDepartureAirport(Departure.getString("AirportCode"));
                        }
                        if (Departure.has("ScheduledTimeLocal")) {
                            JSONObject scheduleTime = Departure.getJSONObject("ScheduledTimeLocal");
                            if (scheduleTime.has("DateTime")) {
                                spots.setDepartureTime(scheduleTime.getString("DateTime"));
                            }
                        }
                        if (Departure.has("Terminal")) {
                            JSONObject Terminal = Departure.getJSONObject("Terminal");
                            if (Terminal.has("Name")) {
                                spots.setDepartureTerminal(Terminal.getString("Name"));
                            }
                        }
                    }

                    if (singleFlight.has("Arrival")) {
                        JSONObject Arrival = singleFlight.getJSONObject("Arrival");
                        if (Arrival.has("AirportCode")) {
                            spots.setArrivalAirport(Arrival.getString("AirportCode"));
                        }
                        if (Arrival.has("ScheduledTimeLocal")) {
                            JSONObject scheduleTime = Arrival.getJSONObject("ScheduledTimeLocal");
                            if (scheduleTime.has("DateTime")) {
                                spots.setArrivalTime(scheduleTime.getString("DateTime"));
                            }
                        }
                        if (Arrival.has("Terminal")) {
                            JSONObject Terminal = Arrival.getJSONObject("Terminal");
                            if (Terminal.has("Name")) {
                                spots.setArrivalTerminal(Terminal.getString("Name"));
                            }
                        }
                    }

                    if (singleFlight.has("MarketingCarrier")) {
                        JSONObject MarketingCarrier = singleFlight.getJSONObject("MarketingCarrier");
                        if (MarketingCarrier.has("AirlineID")) {
                            spots.setAirlines(MarketingCarrier.getString("AirlineID"));
                        }
                        if (MarketingCarrier.has("FlightNumber")) {
                            spots.setAirlineNumber(MarketingCarrier.getString("FlightNumber"));
                        }
                    }

                    flightSpots.add(spots);
                }


                model.setFlightSpotsList(flightSpots);
                if (!fsList.contains(model)) {
                    fsList.add(model);
                }

            }

            return fsList;
        } catch (JSONException e) {
            Log.i(LOG_TAG, "Problem parsing the JSON results", e);
        }
        return fsList;

    }
}