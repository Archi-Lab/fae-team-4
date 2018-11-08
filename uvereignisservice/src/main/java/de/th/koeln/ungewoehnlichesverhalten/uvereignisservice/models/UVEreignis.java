package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UVEreignis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private DVPerson dvPerson;

    private Date zeitstempel;

    private Sprachnachricht sprachnachricht;

    private Dankenachricht dankenachricht;

    long getId() {
        return id;
    }

    Date getZeitstempel() {
        return zeitstempel;
    }

    void setZeitstempel(Date timestamp) {
        this.zeitstempel = timestamp;
    }

    DVPerson getDVPerson() {
        return dvPerson;
    }

    void setDVPerson(DVPerson dp) {
        this.dvPerson = dp;
    }

    Sprachnachricht getSprachnachricht() {
        return sprachnachricht;
    }

    void setSprachnachricht(Sprachnachricht sprachnachricht) {
        this.sprachnachricht = sprachnachricht;
    }

    Dankenachricht getDankenachricht() {
        return dankenachricht;
    }

    void setDankenachricht(Dankenachricht dankenachricht) {
        this.dankenachricht = dankenachricht;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}

