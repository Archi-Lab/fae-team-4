package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Anlaufstelle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Embedded
    private Position position;
    @OneToMany(mappedBy="anlaufstelle", fetch = FetchType.EAGER)
    private List<Mitarbeiter> mitarbeiter = new ArrayList<>();
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

    public String getName() {
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

    public Position getPosition() {
        return position;
    }

    void setPosition(Position position) {
        this.position = position;
    }

    public List<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.add(mitarbeiter);
    }

    public void removeMitarbeiter(long mid) {
        mitarbeiter.remove(mid);
    }
}
