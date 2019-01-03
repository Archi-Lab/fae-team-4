package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
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
