package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
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
        // todo: kann das überorüft werden?
        return true;
    }
}
