package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

    private String mStreet;
    private String mNumber;

    public Adresse() { }

    public Adresse(String street, String number){
        mNumber = number;
        mStreet = street;
    }

    public String getStrasse() {
        return mStreet;
    }

    public void setStrasse(String mStreet) {
        this.mStreet = mStreet;
    }

    public String getNummer() {
        return mNumber;
    }

    public void setNummer(String mNumber) {
        this.mNumber = mNumber;
    }
}
