package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@Entity
public class DVP {

    @Id
    private UUID dvpId;

    private String bildUrl;

    private UUID trackerId;

    @OneToMany()
    private List<Aufenthaltsort> aufenthaltsorte;

    public DVP() {

    }

    public DVP(final UUID id) {
        this.dvpId = id;
    }

    public DVP(final UUID id, final UUID trackerId, final String bildUrl) {
        this.dvpId = id;
        this.trackerId = trackerId;
        this.bildUrl = bildUrl;
    }

    public void addAufenthaltsort(Aufenthaltsort ort)
    {
        if(this.aufenthaltsorte == null || this.aufenthaltsorte.isEmpty())
            this.aufenthaltsorte = new ArrayList<>();

        if(ort == null)
            throw new IllegalArgumentException("Ungültiger Ort");

        this.aufenthaltsorte.add(ort);
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }
}
