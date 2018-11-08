package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import javax.persistence.Embeddable;

@Embeddable
public class Sprachnachricht {

    private byte[] sprachnachricht;

    Sprachnachricht() { }

    Sprachnachricht(byte[] message){
        sprachnachricht = message;
    }

    byte[] getSprachnachricht() {
        return sprachnachricht;
    }

    public void setSprachnachricht(byte[] sprachnachricht) {
        this.sprachnachricht = sprachnachricht;
    }
}
