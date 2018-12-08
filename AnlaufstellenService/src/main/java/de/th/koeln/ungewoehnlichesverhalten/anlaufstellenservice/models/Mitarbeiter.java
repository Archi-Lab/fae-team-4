package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    public long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="anlaufstelle_id")
    private Anlaufstelle anlaufstelle;

    @Getter
    @Column(nullable = false)
    private String vorname;

    @Getter
    @Column(nullable = false)
    private String nachname;

    public Mitarbeiter() {

    }

    public Mitarbeiter(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}
