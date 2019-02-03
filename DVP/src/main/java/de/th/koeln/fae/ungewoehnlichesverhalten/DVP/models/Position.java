package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;


import javax.persistence.Embeddable;

@Embeddable
public class Position {

    private double latitude;
    private double longitude;

    public Position(){

    }

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }


    @Override
    public String toString() { return this.latitude + " / " + this.longitude; }
}