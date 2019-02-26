package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo;

import javax.persistence.Embeddable;

@Embeddable
public class Altitude {

    private final double altitude;

    public Altitude(){
        altitude = 0;
    }

    public Altitude(double alt) {
        if(!isValid(alt)){
            throw new IllegalArgumentException("Invalid altitude");
        }

        altitude = alt;
    }

    private boolean isValid(double lat){
        return true;
    }

    public double getAltitude() {
        return altitude;
    }
}
