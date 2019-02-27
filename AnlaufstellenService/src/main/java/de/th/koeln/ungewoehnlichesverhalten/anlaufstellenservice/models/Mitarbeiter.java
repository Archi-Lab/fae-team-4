package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
/**
 * Klasse für die Mitarbeiter einer Anlaufstelle (MAS)
 * anlaufstelle enthält die Anlaufstelle (Arbeitgeben) des Mitarbeiters
 * vorname enthält den Vornamen (Details: siehe Klasse Vorname)
 * nachname enthält den Nachnamen (Details: siehe Klasse Nachname)
 */
@Entity
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="anlaufstelle_id")
    private Anlaufstelle anlaufstelle;

    @Getter
    @Column(nullable = false)
    private Vorname vorname;

    @Getter
    @Column(nullable = false)
    private Nachname nachname;

    public Mitarbeiter() {

    }

    public Mitarbeiter(Vorname vorname, Nachname nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
