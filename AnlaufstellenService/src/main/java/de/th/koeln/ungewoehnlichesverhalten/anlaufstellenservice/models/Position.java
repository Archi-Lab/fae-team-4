package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class    Position {

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

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
