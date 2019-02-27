package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address.Adresse;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse für eine Anlaufstelle
 * name enthält den Namen der Anlaufstalle
 * mitarbeiter enhält eine Liste der Mitarbeiter (MAS, Details: siehe Klasse Mitarbeiter)
 * adresse enhält die Adresse der Anlaufstelle (Details: siehe Klasse Adresse)
 */
@Entity
@Setter
@Getter
public class Anlaufstelle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    @JoinColumn(name = "anlaufstelle_id")
    private List<Mitarbeiter> mitarbeiter = new ArrayList<>();

    private AnlaufstellenName name;

    @Embedded
    private Adresse adresse;


    public Anlaufstelle() {

    }

    public Anlaufstelle(AnlaufstellenName name, Adresse adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

    public AnlaufstellenName getName() {
        return name;
    }

    public void setName(AnlaufstellenName name) {
        this.name = name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
