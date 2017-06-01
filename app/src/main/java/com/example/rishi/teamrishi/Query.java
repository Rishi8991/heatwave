package com.example.rishi.teamrishi;

import android.graphics.Color;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Query extends MapsActivity {

    static String queryMethod(String url) throws Exception{
        String line = new String();
        try {
            URL obj = new URL(url);
            HttpURLConnection connect = (HttpURLConnection) obj.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connect.getInputStream()));
            line = br.readLine();
            Log.d("test",line);
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return line;
    }

    static List<tuple> parseToTuple(String inputs){
        List<tuple> listToReturn = new ArrayList<>();
        String[] splitList = inputs.split("\"");
        Log.d("inputs", splitList.toString());
        Log.d("length", String.valueOf(splitList.length));
        for (int i = 3; i < splitList.length; i+=4) {
            String[] latlng = splitList[i-2].split("&");
            //Log.d("latlng", latlng[0] + latlng[1]);
            String[] rgbtweet = splitList[i].split("&");
            //Log.d("rgb", rgb[0] + rgb[1] + rgb[2]);
            LatLng newLatLng = new LatLng(Float.parseFloat(latlng[0]), Float.parseFloat(latlng[1]));
            //Log.d("newLatLng", newLatLng.toString());
            String tweet = rgbtweet[3];
            tuple newTuple = new tuple(newLatLng, 30000, Color.argb( 100, Integer.parseInt(rgbtweet[0]), Integer.parseInt(rgbtweet[1]), Integer.parseInt(rgbtweet[2])), tweet);
            Log.d("Tuple", newTuple.toString());
            listToReturn.add(newTuple);
        }

        return listToReturn;
    }

}
