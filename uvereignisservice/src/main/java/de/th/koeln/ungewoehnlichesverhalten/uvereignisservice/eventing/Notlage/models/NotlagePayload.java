package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.eventing.Notlage.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NotlagePayload {

    public int notlageId;

    public DVP dvp;

    public String status;

    public String idOrigin;

    public boolean geloest;

    public boolean bestaetigt;

    public boolean offen;

    public ExtraData extraData;

    public NotlageBestaetigung notlageBestaetigung;

    public NotlageLoesung notlageLoesung;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private class ExtraData {
        public String data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private class DVP {
        public int dvpID;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private class NotlageLoesung {
        public boolean istGeloest;
        public int notlageLoesungId;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private class NotlageBestaetigung {
        public boolean istBestaetigt;
        public int notlageBestaetigungid;
    }
}
