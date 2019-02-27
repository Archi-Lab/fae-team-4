package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;


import javax.persistence.Embeddable;

/**
 * Klasse für die Bilder von Dementiell Veränderten Personen
 * bild enthält die URL auf ein Profilbild
 */
@Embeddable
public class Bild {
    private final String bild;

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

    public String getBild() {
        return bild;
    }
}
