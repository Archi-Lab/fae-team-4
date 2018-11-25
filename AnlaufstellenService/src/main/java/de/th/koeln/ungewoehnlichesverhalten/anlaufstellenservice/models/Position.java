package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;


import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;

@Embeddable
public class Position {

    private final double latitude;
    private final double longitude;

    public Position() {
        this.latitude = 0.0;
        this.longitude = 0.0;
    }

    public Position(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }

    double getLatitude() {
        return latitude;
    }

    double getLongitude() {
        return longitude;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
