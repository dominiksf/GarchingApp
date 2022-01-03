package com.example.garchingnews.mvg;

import android.location.Location;

public class DepartureItem {

    public String destination;
    public int departure;

    public DepartureItem(String destination, int departure) {
        this.destination = destination;
        this.departure = departure;

    }


    public int getDeparture() {
        return departure;
    }
}
