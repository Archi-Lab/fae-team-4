package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

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

    void setName(String name) {
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

    List<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    void setMitarbeiterListe(List<Mitarbeiter> mitarbeiterListe) {
        this.mitarbeiterListe = mitarbeiterListe;
    }
}
