package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person;

import lombok.Getter;

import javax.persistence.Embeddable;


@Embeddable
@Getter
public class Nachname {
    private final String nachname;

    public Nachname(){
        // todo: Default Vorname
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

