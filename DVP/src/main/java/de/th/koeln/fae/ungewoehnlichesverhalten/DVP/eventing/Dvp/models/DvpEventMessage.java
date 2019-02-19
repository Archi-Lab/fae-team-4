package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Dvp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models.TrackerTrackedPayload;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DvpEventMessage {


    public UUID id;

    public String type;

    public Long version;

    public UUID key;

    public String time;

    public DvpPayload payload;
}
