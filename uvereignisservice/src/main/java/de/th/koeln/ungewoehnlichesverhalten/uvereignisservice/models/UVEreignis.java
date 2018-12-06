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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(Date timestamp) {
        this.zeitstempel = timestamp;
    }

    public DVPerson getDVPerson() {
        return dvPerson;
    }

    public void setDVPerson(DVPerson dp) {
        this.dvPerson = dp;
    }

    public Sprachnachricht getSprachnachricht() {
        return sprachnachricht;
    }

    public void setSprachnachricht(Sprachnachricht sprachnachricht) {
        this.sprachnachricht = sprachnachricht;
    }

    public Dankenachricht getDankenachricht() {
        return dankenachricht;
    }

    public void setDankenachricht(Dankenachricht dankenachricht) {
        this.dankenachricht = dankenachricht;
    }

    @Override
    public String toString(){
        return this.zeitstempel + " - " + this.dvPerson;
    }
}

