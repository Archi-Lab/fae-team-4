package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Klasse für Longitude (Längengrad) der GPS Position
 */
@Embeddable
@Setter
@Getter
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
}
