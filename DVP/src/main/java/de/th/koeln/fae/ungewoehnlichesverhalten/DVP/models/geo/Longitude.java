package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class Longitude {

    private final double longitude;

    public Longitude(){
        longitude = 0;
    }

    public Longitude(double lng) {
        if(!isValid(lng)){
            throw new IllegalArgumentException("Invalid longitude");
        }

        longitude = lng;
    }

    private boolean isValid(double lat){
        return lat >= -180 && lat <= 180;
    }

    public double getLongitude() {
        return longitude;
    }
}
