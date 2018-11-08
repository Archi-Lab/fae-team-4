package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;

@Embeddable
public class Position {
    private double latitude;
    private double longitude;

    Position(){   }

    Position(double lat, double lon){
        latitude = lat;
        longitude = lon;
    }

    double getLatitude() { return latitude; }

    void setLatitude(double latitude) { this.latitude = latitude; }

    double getLongitude() { return longitude; }

    void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}

