package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address.Adresse;
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
    private Adresse adresse;


    public Anlaufstelle() {

    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
