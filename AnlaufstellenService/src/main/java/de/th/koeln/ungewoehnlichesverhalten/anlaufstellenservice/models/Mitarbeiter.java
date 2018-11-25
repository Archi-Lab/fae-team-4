package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class Mitarbeiter {

    @ManyToOne
    @JoinColumn(name="anlaufstelle_id", nullable=false)
    private Anlaufstelle anlaufstelle;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private final String vorname;
    private final String name;

    public Mitarbeiter(String vorname, String nachname) {
        this.vorname = vorname;
        this.name = nachname;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
