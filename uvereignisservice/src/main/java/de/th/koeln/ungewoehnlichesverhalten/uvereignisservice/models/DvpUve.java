package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Setter
@Getter
@Embeddable
public class DvpUve {
    @Embedded
    private DVPerson dvPerson;

    @Embedded
    private Sprachnachricht sprachnachricht;
    private Status status;


    public DvpUve() {
        this.status = Status.ERSTELLT;
    }

    @Override
    public String toString() {
        return this.dvPerson.toString() + ": " + this.status;
    }
}
