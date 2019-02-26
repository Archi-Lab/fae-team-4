package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Straße {
    private final String straße;

    public Straße()
    {
        straße = "";
    }

    public Straße(String str) {
        if(!isValid(str)){
            throw new IllegalArgumentException("Invalid street");
        }

        straße = str;
    }

    private boolean isValid(String str){
        return str != null && str.length() > 1 && str.length() < 100;
    }
}
