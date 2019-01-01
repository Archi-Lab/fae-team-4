package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Stadt {
    private final String stadt;

    public Stadt()
    {
        // todo: Default für Stadt ???
        stadt = "";
    }

    public Stadt(String str) {
        if(!isValid(str)){
            throw new IllegalArgumentException("Invalid Stadt");
        }

        stadt = str;
    }

    private boolean isValid(String str){
        return str != null && str.length() > 1 && str.length() < 200;
    }
}
