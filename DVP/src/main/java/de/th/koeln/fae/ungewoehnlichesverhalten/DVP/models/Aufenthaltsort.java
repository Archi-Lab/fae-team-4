package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Entity
public class Aufenthaltsort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date timestamp;

    @Embedded
    private Position position;


    public Aufenthaltsort() {

    }

    public Aufenthaltsort(Date timestamp, Position position) {
        this.timestamp = timestamp;
        this.position = position;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
