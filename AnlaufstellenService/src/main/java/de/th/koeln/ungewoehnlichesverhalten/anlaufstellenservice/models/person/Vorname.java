package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Vorname {
    private final String vorname;

    public Vorname(){
        vorname = "";
    }

    public Vorname(String name) {
        if(!isValid(name)){
            throw new IllegalArgumentException("Invalid vorname");
        }

        vorname = name;
    }

    private boolean isValid(String name){
        return name != null && name.length() > 1 && name.length() < 200;
    }
}
