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

    private String Straße;
    private String Hausnummer;

    public Adresse(String straße, String hausnummer){
        Hausnummer = hausnummer;
        Straße = straße;
    }
}
