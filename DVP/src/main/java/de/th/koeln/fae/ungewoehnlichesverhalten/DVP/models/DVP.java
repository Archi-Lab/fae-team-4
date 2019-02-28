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
    private UUID id;

    @Embedded
    private Bild bild;

    private UUID trackerId;

    @OneToMany()
    private List<Aufenthaltsort> aufenthaltsorte;

    public DVP() {

    }

    public DVP(final UUID id) {
        this.id = id;
    }

    public DVP(final UUID id, final UUID trackerId, final String bildUrl) {
        this.id = id;
        this.trackerId = trackerId;
        this.bild = new Bild(bildUrl);
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

    public void setTrackerId(UUID trackerId) {
        this.trackerId = trackerId;
    }

    public UUID getId() {
        return id;
    }

    public String getBildUrl() {
        return bild.getBild();
    }

    public UUID getTrackerId() {
        return trackerId;
    }

    public List<Aufenthaltsort> getAufenthaltsorte() {
        return aufenthaltsorte;
    }

    public void setAufenthaltsorte(List<Aufenthaltsort> aufenthaltsorte) {
        this.aufenthaltsorte = aufenthaltsorte;
    }
}
