package com.Hackathon.bialgenieapp.Queries;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.Hackathon.bialgenieapp.Models.HotelsModel;
import com.Hackathon.bialgenieapp.Models.RestaurantShoppingModel;

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

public class HotelsQuery {

    private static String LOG_TAG = HotelsQuery.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<HotelsModel> fetchHotelsResults(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);
        //  URL locationUrl = createUrl("https://hotels4.p.rapidapi.com/locations/v2/search?query="+location);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);         //makeHttpRequest is taking url object
            Log.i(LOG_TAG, "JsonResponse had been taken by httpReq");
        } catch (IOException e) {
            Log.i(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create an {@link Event} object

        ArrayList<HotelsModel> info = extractFeatureFromJson(jsonResponse);

        // Return the {@link Event}
        return info;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getLocationId(String requestUrl) {
        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);         //makeHttpRequest is taking url object
            Log.i(LOG_TAG, "JsonResponse had been taken by httpReq");
        } catch (IOException e) {
            Log.i(LOG_TAG, "Error closing input stream", e);
        }

        String locationId = getDestinationId(jsonResponse);

        // Return the {@link Event}
        return locationId;
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

            urlConnection.setReadTimeout(15000 /* milliseconds */);
            urlConnection.setConnectTimeout(20000 /* milliseconds */);

            urlConnection.setRequestProperty("x-rapidapi-host", "hotels4.p.rapidapi.com");
            urlConnection.setRequestProperty("x-rapidapi-key", "4f2ed34c31mshd5f952f41b7c244p1d2d8cjsn1313966a21eb");

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

    private static ArrayList<HotelsModel> extractFeatureFromJson(String jsonResponse) {
        // If the JSON string is empty or null, then return early.
        ArrayList<HotelsModel> list = new ArrayList<>();
        if (TextUtils.isEmpty(jsonResponse)) {
            return list;
        }

        try {

            JSONObject mainObj = new JSONObject(jsonResponse);
            JSONObject data = mainObj.getJSONObject("data");
            JSONObject body = data.getJSONObject("body");
            JSONObject searchResults = body.getJSONObject("searchResults");
            JSONArray results = searchResults.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {

                HotelsModel model = new HotelsModel();
                JSONObject curObj = results.getJSONObject(i);

                if (curObj.has("id")) {
                    model.setId(curObj.getLong("id"));
                }

                if (curObj.has("name")) {
                    model.setName(curObj.getString("name"));
                }

                if (curObj.has("starRating")) {
                    model.setStarRating(curObj.getDouble("starRating"));
                }

                if (curObj.has("address")) {

                    JSONObject address = curObj.getJSONObject("address");
                    String addressStr = "";

                    if (address.has("streetAddress")) {
                        addressStr += address.getString("streetAddress");
                    }

                    if (address.has("extendedAddress")) {
                        addressStr += ", " + address.getString("extendedAddress");
                    }

                    if (address.has("locality")) {
                        addressStr += ", " + address.getString("locality");
                    }

                    if (address.has("postalCode")) {
                        addressStr += ", " + address.getString("postalCode");
                    }

                    if (address.has("region")) {
                        addressStr += ", " + address.getString("region");
                    }

                    model.setAddress(addressStr);

                }

                if (curObj.has("coordinate")) {
                    JSONObject coordinate = curObj.getJSONObject("coordinate");
                    model.setLatitude(coordinate.getDouble("lat"));
                    model.setLongitude(coordinate.getDouble("lon"));
                }

                if (curObj.has("optimizedThumbUrls")) {
                    JSONObject optimizedThumbUrls = curObj.getJSONObject("optimizedThumbUrls");
                    model.setThumbnail(optimizedThumbUrls.getString("srpDesktop"));
                }

                if (curObj.has("ratePlan")) {
                    JSONObject ratePlan = curObj.getJSONObject("ratePlan");
                    if (ratePlan.has("price")) {
                        JSONObject price = ratePlan.getJSONObject("price");
                        if (price.has("info"))
                            model.setPriceInfo(price.getString("info"));
                        if(price.has("current"))
                        model.setCurrentPrice(price.getString("current"));
                    }
                }

                list.add(model);

            }

            return list;
        } catch (JSONException e) {
            Log.i(LOG_TAG, "Problem parsing the JSON results", e);
        }
        return list;

    }

    private static String getDestinationId(String jsonResponse) {

        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }

        try {
            JSONObject mainObj = new JSONObject(jsonResponse);
            if (mainObj.has("suggestions")) {
                JSONArray suggestions = mainObj.getJSONArray("suggestions");
                JSONArray entities = suggestions.getJSONObject(0).getJSONArray("entities");
                String destinationId = entities.getJSONObject(0).getString("destinationId");
                Log.i(LOG_TAG, "DESTINATION ID: " + destinationId);
                return destinationId;
            }

        } catch (JSONException e) {
            Log.i(LOG_TAG, "Problem parsing the JSON results", e);
        }

        return null;
    }

}