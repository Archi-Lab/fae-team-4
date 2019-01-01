package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.geo;


import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
public class Position {
    @Embedded
    private final Latitude latitude;
    @Embedded
    private final Longitude longitude;

    public Position() {
        this.latitude = new Latitude();
        this.longitude = new Longitude();
    }

    public Position(Latitude lat, Longitude lon) {
        latitude = lat;
        longitude = lon;
    }
}
