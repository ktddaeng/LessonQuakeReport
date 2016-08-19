package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Kim on 8/15/2016.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public static final String LOG_TAG = EarthquakeAdapter.class.getName();
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> eq) {
        super(context, 0, eq);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Earthquake earthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.textview_magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitudeTextView.setText(formatter.format(earthquake.getMagnitude()));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        //LOCATION TEXT
        String primaryLocation, locationOffset, originalLocation = earthquake.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView distTextView = (TextView) listItemView.findViewById(R.id.textview_distance);
        distTextView.setText(locationOffset);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.textview_location);
        locationTextView.setText(primaryLocation);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.textview_date);
        dateTextView.setText(earthquake.getDate());
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.textview_time);
        timeTextView.setText(earthquake.getTime());

        return listItemView;
    }

    private int getMagnitudeColor(double mag) {
        int magnitudeColorResourceId;
        int magnFloor = (int)Math.floor(mag);
        switch (magnFloor) {
            case 0:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
