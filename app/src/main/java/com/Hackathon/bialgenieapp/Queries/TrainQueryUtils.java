package com.Hackathon.bialgenieapp.Queries;

import com.Hackathon.bialgenieapp.Models.TrainData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TrainQueryUtils {



    public static String makeHttpRequest(String trainName,String trainNumber) throws IOException {
        OkHttpClient client=new OkHttpClient();
        RequestBody body;

        MediaType media=MediaType.parse("application/json");

        if (!trainName.isEmpty()) {
            body = RequestBody.create(media, "{\r \"search\": \"" + trainName + "\"\r }");
        }
        else{
            body = RequestBody.create(media, "{\r \"search\": \"" + trainNumber + "\"\r }");
        }


        Request request=new Request.Builder()
                .url("https://trains.p.rapidapi.com/")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("x-rapidapi-host", "trains.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "bf5611f4edmsh65c91ec45647d9bp1ffc4cjsn6ab6cef75a0c")
                .build();

        Response response=client.newCall(request).execute();

        return response.body().string();
    }

    public static List<TrainData> parseJsonResponse(String response) throws JSONException {
        List<TrainData> trainList=new ArrayList<>();

        JSONArray jsonArray=new JSONArray(response);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject=jsonArray.optJSONObject(i);

            String trainName=jsonObject.getString("name");
            String arrivalStn=jsonObject.optString("train_from");
            String destinationStn=jsonObject.optString("train_to");

            JSONObject dataObject=jsonObject.optJSONObject("data");
            JSONObject daysObject=dataObject.optJSONObject("days");

            HashMap<String,String> daysAvailable=new HashMap<>();

            daysAvailable.put("Fri",daysObject.optString("Fri"));
            daysAvailable.put("Mon",daysObject.optString("Mon"));
            daysAvailable.put("Sat",daysObject.optString("Sat"));
            daysAvailable.put("Sun",daysObject.optString("Sun"));
            daysAvailable.put("Thu",daysObject.optString("Thu"));
            daysAvailable.put("Tue",daysObject.optString("Tue"));
            daysAvailable.put("Wed",daysObject.optString("Wed"));

            JSONArray classesArray=dataObject.optJSONArray("classes");
            List<String> classesArr=new ArrayList<>();
            for (int j = 0; j < classesArray.length(); j++) {
                classesArr.add(classesArray.optString(j));
            }

            trainList.add(new TrainData(trainName,arrivalStn,destinationStn,daysAvailable,classesArr));



        }



        return trainList;
    }
}
