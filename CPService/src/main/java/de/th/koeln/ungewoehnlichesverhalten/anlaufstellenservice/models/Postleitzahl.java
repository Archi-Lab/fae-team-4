package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import javax.persistence.Embeddable;

@Embeddable
public class Postleitzahl {

    private String mZipCode;

    Postleitzahl(String zipCode){
        mZipCode = zipCode;
    }

    Postleitzahl() { }

    public String getPLZ() {
        return mZipCode;
    }

    public void setPLZ(String plz) {
        this.mZipCode = plz;
    }
}
