package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo;


import lombok.Getter;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Position {
    @Embedded
    private final Latitude latitude;
    @Embedded
    private final Longitude longitude;
    @Embedded
    private final Altitude altitude;

    public Position() {
        this.latitude = new Latitude();
        this.longitude = new Longitude();
        this.altitude = new Altitude();
    }

    public Position(Latitude latitude, Longitude longitude, Altitude altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public Longitude getLongitude() {
        return longitude;
    }

    public Altitude getAltitude() {
        return altitude;
    }
}
