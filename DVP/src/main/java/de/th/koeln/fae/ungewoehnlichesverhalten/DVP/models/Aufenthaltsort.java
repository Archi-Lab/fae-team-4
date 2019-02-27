package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Position;
import javax.persistence.*;
import java.util.UUID;
import java.time.Instant;

/**
 * Klasse für den Aufenthaltsort einer Dementiell Veränderten Personen
 * Der Aufenthaltsort wird durch die Kombination einer Position und eines Zeitstempels gebildet
 */
@Entity
public class Aufenthaltsort {

    @Id
    private UUID id;

    private Instant timestamp;

    @Embedded
    private Position position;

    public Aufenthaltsort() {
        this.id = UUID.randomUUID();
    }

    public Aufenthaltsort(Instant timestamp, Position position) {
        this.id = UUID.randomUUID();
        this.timestamp = timestamp;
        this.position = position;
    }

    public Aufenthaltsort(Instant timestamp, Position position, final UUID id) {
        this.id = id;
        this.timestamp = timestamp;
        this.position = position;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public UUID getId() { return this.id; }

    public void setId(final UUID id) { this.id = id; }

    public Instant getTimestamp() {
        return timestamp;
    }
}
