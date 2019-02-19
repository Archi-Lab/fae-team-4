package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackerTrackedEventMessage {


    public UUID id;

    public String type;

    public Long version;

    public UUID key;

    public String time;

    public TrackerTrackedPayload payload;
}
