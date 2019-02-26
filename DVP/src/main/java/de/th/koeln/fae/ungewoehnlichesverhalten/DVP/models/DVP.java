package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

/**
 * Klasse für Dementiell Veränderte Personen (DVP)
 * bildUrl enthält die URL zum Profilbild der DVP
 * trackerId enthält die eindeutige UUID des zugehörigen Trackers
 * aufenthaltsorte ist eine Liste mit den vergangenen Positionen der DVP, zugeordnet über die trackerId
 */
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

    /**
     * Hinzufügen von Aufenthaltsorten. Liste wird initialisiert, falls nötig.
     * @param ort
     */
    public void addAufenthaltsort(Aufenthaltsort ort)
    {
        if(this.aufenthaltsorte == null || this.aufenthaltsorte.isEmpty()) {
            this.aufenthaltsorte = new ArrayList<>();
        }

        if(ort == null) {
            throw new IllegalArgumentException("Ort cannot be null");
        }

        this.aufenthaltsorte.add(ort);
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }

    public UUID getDvpId() {
        return dvpId;
    }

    public String getBildUrl() {
        return bildUrl;
    }

    public UUID getTrackerId() {
        return trackerId;
    }

    public List<Aufenthaltsort> getAufenthaltsorte() {
        return aufenthaltsorte;
    }
}
