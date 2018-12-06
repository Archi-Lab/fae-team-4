package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="anlaufstelle_id")
    private Anlaufstelle anlaufstelle;

    @Column(nullable = false)
    private String vorname;
    @Column(nullable = false)
    private String nachname;

    public Mitarbeiter() {

    }

    public Mitarbeiter(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
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

    public String getNachname() {
        return nachname;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
