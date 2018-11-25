package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Postleitzahl {

    private String mZipCode;

    public Postleitzahl(String zipCode){
        mZipCode = zipCode;
    }

    public String getPLZ() {
        return mZipCode;
    }

    public void setPLZ(String plz) {
        this.mZipCode = plz;
    }
}
