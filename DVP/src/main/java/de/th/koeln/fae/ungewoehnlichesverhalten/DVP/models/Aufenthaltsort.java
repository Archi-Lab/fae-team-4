package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aufenthaltsort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date timestamp;

    @Embedded
    private Position position;

    public Aufenthaltsort(Date timestamp, Position position) {
        this.timestamp = timestamp;
        this.position = position;
    }
}
