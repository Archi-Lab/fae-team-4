package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;


@Embeddable
@Getter
@Setter
public class Nachname {
    private final String nachname;

    public Nachname(){
        nachname = "";
    }

    public Nachname(String name) {
        if(!isValid(name)){
            throw new IllegalArgumentException("Invalid nachname");
        }

        nachname = name;
    }

    private boolean isValid(String name){
        return name != null && name.length() > 1 && name.length() < 200;
    }
}

