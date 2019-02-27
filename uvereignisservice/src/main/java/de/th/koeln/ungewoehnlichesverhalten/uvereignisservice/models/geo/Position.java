package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.geo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Klasse für eine GPS Position
 * Wird durch Latitude und Longitude definiert
 */
@Embeddable
@Getter
@Setter
public class Position {
    @Embedded
    private Latitude latitude;
    @Embedded
    private Longitude longitude;

    public Position() {
        this.latitude = new Latitude();
        this.longitude = new Longitude();
    }

    public Position(Latitude lat, Longitude lon) {
        latitude = lat;
        longitude = lon;
    }
}
