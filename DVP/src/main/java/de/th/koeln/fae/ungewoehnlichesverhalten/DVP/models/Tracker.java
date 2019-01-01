package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Tracker {
    private final String trackerId;

    public Tracker(){
        trackerId = null;
    }

    public Tracker(String trackerId) {
        if(!isValid(trackerId)){
            throw new IllegalArgumentException("Invalid trackerId");
        }

        this.trackerId = trackerId;
    }

    private boolean isValid(String trackerId)
    {
        // todo: Wie sieht die Tracker ID aus?
        return trackerId != null && trackerId.length() > 1 && trackerId.length() < 200;
    }
}
