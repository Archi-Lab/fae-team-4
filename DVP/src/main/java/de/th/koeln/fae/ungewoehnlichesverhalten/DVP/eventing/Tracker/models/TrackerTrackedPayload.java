package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Tracker.models.TrackerPosition;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackerTrackedPayload {

    public UUID trackerId;

    public TrackerPosition currentPosition;
}
