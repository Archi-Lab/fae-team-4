package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;

@Embeddable
public class Position {
    private double latitude;
    private double longitude;

    Position(){   }

    public Position(double lat, double lon){
        latitude = lat;
        longitude = lon;
    }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}

