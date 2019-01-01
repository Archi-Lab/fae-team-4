package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Hausnummer {
    private final String hausnummer;

    public Hausnummer(){
        hausnummer = "1";
    }

    public Hausnummer(String str) {
        if(!isValid(str)){
            throw new IllegalArgumentException("Invalid Hausnummer");
        }

        hausnummer = str;
    }

    private boolean isValid(String str){
        return str != null && str.length() > 0 && str.length() < 10;
    }
}
