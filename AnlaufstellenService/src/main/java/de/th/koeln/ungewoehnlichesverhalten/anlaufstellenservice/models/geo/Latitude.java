package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo;

import lombok.Getter;
import javax.persistence.Embeddable;

@Embeddable
@Getter
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
}
