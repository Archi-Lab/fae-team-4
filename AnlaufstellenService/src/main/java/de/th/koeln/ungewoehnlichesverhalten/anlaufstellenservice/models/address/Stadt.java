package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * Klasse für eine Stadt
 */
@Getter
@Setter
@Embeddable
public class Stadt {
    private final String stadt;

    public Stadt()
    {
        stadt = "";
    }

    public Stadt(String stadt) {
        if(!isValid(stadt)){
            throw new IllegalArgumentException("Invalid Stadt");
        }

        this.stadt = stadt;
    }

    private boolean isValid(String str){
        return str != null && str.length() > 1 && str.length() < 200;
    }
}
