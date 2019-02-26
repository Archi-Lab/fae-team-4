package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;


import javax.persistence.Embeddable;

@Embeddable
public class Position {

    private double latitude;
    private double longitude;
    private double altitude;

    public Position(){

    }

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }


    @Override
    public String toString() { return this.latitude + " / " + this.longitude; }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }
}