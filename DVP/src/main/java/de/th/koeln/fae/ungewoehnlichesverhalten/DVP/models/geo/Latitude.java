package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo;

import javax.persistence.Embeddable;

/**
 * Klasse für Latitude (Breitengrad) der GPS Position
 */
@Embeddable
public class Latitude {

    private final double latitude;

    public Latitude(){
        latitude = 0;
    }

    public Latitude(double lat) {
        if(!isValid(lat)){
            throw new IllegalArgumentException("Invalid latitude");
        }

        latitude = lat;
    }

    private boolean isValid(double lat){
        return lat >= -90 && lat <= 90;
    }

    public double getLatitude() {
        return latitude;
    }
}
