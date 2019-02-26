package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo.Position;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Setter
@Getter
public class Adresse {

    @Embedded
    private Straße Straße;

    @Embedded
    private Hausnummer Hausnummer;

    @Embedded
    private Postleitzahl Postleitzahl;

    @Embedded
    private Position Position;

    @Embedded
    private Stadt Stadt;


    public Adresse(){
        Hausnummer = new Hausnummer();
        Straße = new Straße();
        Postleitzahl = new Postleitzahl();
        Position = new Position();
        Stadt = new Stadt();
    }

    public Adresse(Postleitzahl plz, Stadt stadt, Straße straße, Hausnummer hausnummer, Position pos){
        Postleitzahl = plz;
        Hausnummer = hausnummer;
        Straße = straße;
        Position = pos;
        Stadt = stadt;
    }
}
