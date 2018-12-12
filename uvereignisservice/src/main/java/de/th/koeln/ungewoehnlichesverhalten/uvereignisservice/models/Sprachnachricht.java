package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
public class Sprachnachricht {

    private byte[] sprachnachricht;

    public Sprachnachricht(byte[] message){
        sprachnachricht = message;
    }

}
