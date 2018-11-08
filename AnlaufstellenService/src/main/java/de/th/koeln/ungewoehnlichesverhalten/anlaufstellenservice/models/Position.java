package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;

@Embeddable
public class Position {

    private double latitude;
    private double longitude;

    void setKoordinaten(double lat, double lon){
        latitude = lat;
        longitude = lon;
    }

    double getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    double getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
