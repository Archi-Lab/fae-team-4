package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.eventing.Dvp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

/**
 * Payload für ein DVP Event
 * Bildet eine {@link de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP} ab
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DvpPayload {

    public UUID id;

    public Bild bild;

    public Tracker tracker;
}
