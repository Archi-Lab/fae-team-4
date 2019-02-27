package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotlageEventMessage {


    public UUID id;

    public String type;

    public Long version;

    public UUID key;

    public String time;

    public NotlagePayload payload;
}
