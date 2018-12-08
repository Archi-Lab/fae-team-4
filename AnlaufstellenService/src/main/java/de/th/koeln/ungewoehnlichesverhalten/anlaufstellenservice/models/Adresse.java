package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class Adresse {

    private String mStraße;
    private String mHausnummer;

    public Adresse(String straße, String hausnummer){
        mHausnummer = hausnummer;
        mStraße = straße;
    }
}
