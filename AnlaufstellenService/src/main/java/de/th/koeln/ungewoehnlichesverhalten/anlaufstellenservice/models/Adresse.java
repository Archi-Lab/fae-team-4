package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@NoArgsConstructor
public class Adresse {

    private String mStreet;
    private String mNumber;

    public Adresse(String street, String number){
        mNumber = number;
        mStreet = street;
    }

    public String getStrasse() {
        return mStreet;
    }

    public String getNummer() {
        return mNumber;
    }
}
