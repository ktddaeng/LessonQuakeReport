package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kim on 8/15/2016.
 */
public class Earthquake {
    public static final String LOG_TAG = EarthquakeActivity.class.getSimpleName();
    private long eDate;
    private String eLocation;
    private double eMagnitude;
    private String eURL;

    //Constructor
    public Earthquake( double magn, String location, long date, String url) {
        eDate = date;
        eLocation = location;
        eMagnitude = magn;
        eURL = url;
    }

    public String getDate(){
        Date dateObject = new Date(eDate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");

        return dateFormatter.format(dateObject);
    }

    public String getTime(){
        Date dateObject = new Date(eDate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");

        return dateFormatter.format(dateObject);
    }

    public String getLocation(){
        return eLocation;
    }

    public double getMagnitude() {
        return eMagnitude;
    }

    public String getURL() {
        return eURL;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "eDate='" + eDate + '\'' +
                ", eLocation='" + eLocation + '\'' +
                ", eMagnitude='" + eMagnitude + '\'' +
                '}';
    }
}
