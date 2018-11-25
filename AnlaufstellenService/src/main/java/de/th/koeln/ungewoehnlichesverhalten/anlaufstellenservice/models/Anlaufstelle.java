package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Anlaufstelle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Embedded
    private Position position;
    @OneToMany(mappedBy="anlaufstelle")
    private List<Mitarbeiter> mitarbeiterListe;
    private Adresse adresse;
    private Postleitzahl postleitzahl;
    private String stadt;

    public Anlaufstelle() {
        // TODO generate Position based on address?
        this.setPosition(new Position(0.0, 0.0));
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse address) {
        this.adresse = address;
    }

    public Postleitzahl getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(Postleitzahl zipCode) {
        this.postleitzahl = zipCode;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String cityName) {
        this.stadt = cityName;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    Position getPosition() {
        return position;
    }

    void setPosition(Position position) {
        this.position = position;
    }

    public List<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public void setMitarbeiterListe(List<Mitarbeiter> mitarbeiterListe) {
        this.mitarbeiterListe = mitarbeiterListe;
    }
}
