package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo;

import javax.persistence.Embeddable;

/**
 * Klasse für Altitude (Höhenangabe) der GPS Position
 */
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


    private boolean isValid(double alt){
        return true;
    }

    public double getAltitude() {
        return altitude;
    }
}
