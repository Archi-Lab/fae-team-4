package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Klasse für Latitude (Breitengrad) der GPS Position
 */
@Embeddable
@Getter
@Setter
public class Bild {
    private String bild;

    public Bild(){
        bild = null;
    }

    public Bild(String image) {
        if(!isValid(image)){
            throw new IllegalArgumentException("Invalid image");
        }

        bild = image;
    }

    private boolean isValid(String bild)
    {
        // Die URL auf das Bild kann zum jetzigen Zeitpunkt nicht validiert werden, da Bilder noch nicht in das System integriert wurden.
        // Diese Klasse dient nut dazu diese für später vorzumerken.

        return true;
    }
}
