package com.example.rishi.teamrishi;

import android.graphics.Color;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by root on 04/02/17.
 */

public class tuple {

    private LatLng centre;
    private int radius;
    private int colour;
    private String tweet;


    tuple(LatLng ce, int r, int c, String t) {
        centre = ce;
        radius = r;
        colour = c;
        tweet = t;
    }

    @Override
    public String toString() {
        return "(" + getCentre() + ", " + getRadius() + ", " + getColour() + ", " + getTweet() + ")";
    }

    public LatLng getCentre() {
        return centre;
    }

    public int getRadius() {
        return radius;
    }

    public int getColour() {
        return colour;
    }

    public String getTweet() {
        return tweet;
    }

}
