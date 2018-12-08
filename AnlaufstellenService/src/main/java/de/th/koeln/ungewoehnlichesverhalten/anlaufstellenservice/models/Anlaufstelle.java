package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String name;
    @Embedded
    private Position position;
    @Embedded
    private Adresse adresse;
    private Postleitzahl postleitzahl;
    private String stadt;

    public Anlaufstelle() {
        // TODO generate Position based on address?
        this.setPosition(new Position(0.0, 0.0));
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
