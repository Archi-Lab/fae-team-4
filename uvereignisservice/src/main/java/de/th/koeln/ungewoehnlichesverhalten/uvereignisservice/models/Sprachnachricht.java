package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import javax.persistence.Embeddable;

@Embeddable
public class Sprachnachricht {

    private byte[] sprachnachricht;

    Sprachnachricht() { }

    public Sprachnachricht(byte[] message){
        sprachnachricht = message;
    }

    public byte[] getSprachnachricht() {
        return sprachnachricht;
    }

    public void setSprachnachricht(byte[] sprachnachricht) {
        this.sprachnachricht = sprachnachricht;
    }
}
