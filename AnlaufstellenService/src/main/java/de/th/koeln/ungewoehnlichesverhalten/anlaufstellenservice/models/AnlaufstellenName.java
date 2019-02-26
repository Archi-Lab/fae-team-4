package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class AnlaufstellenName {
    private final String name;

    public AnlaufstellenName(){
        name = "";
    }

    public AnlaufstellenName(String name) {
        if(!isValid(name)){
            throw new IllegalArgumentException("Invalid name");
        }

        this.name = name;
    }

    private boolean isValid(String name){
        return name != null && name.length() > 1 && name.length() < 200;
    }
}

