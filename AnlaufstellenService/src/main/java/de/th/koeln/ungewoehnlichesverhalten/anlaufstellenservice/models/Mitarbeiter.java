package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Mitarbeiter {

    @ManyToOne
    @JoinColumn(name="anlaufstelle_id", nullable=false)
    private Anlaufstelle anlaufstelle;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String vorname;
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    void setVorname(String surname) {
        this.vorname = surname;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
