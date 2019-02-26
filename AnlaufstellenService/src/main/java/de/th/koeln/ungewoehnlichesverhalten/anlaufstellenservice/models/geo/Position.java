package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
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

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
