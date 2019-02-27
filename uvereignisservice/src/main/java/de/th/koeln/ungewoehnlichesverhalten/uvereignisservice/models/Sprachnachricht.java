package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;

/**
 * Klasse für Sprachnachrichten
 * Enthällt aktuell die Spracknachricht in Rohdatenform (byte Array)
 * Könnte zu einem späteren Zeitpunkt in eine URI umgewandelt werden.
 */
@Embeddable
@Setter
@Getter
public class Sprachnachricht {

    private byte[] sprachnachricht;

    public Sprachnachricht(byte[] message){
        sprachnachricht = message;
    }

    protected Sprachnachricht() {}
}
