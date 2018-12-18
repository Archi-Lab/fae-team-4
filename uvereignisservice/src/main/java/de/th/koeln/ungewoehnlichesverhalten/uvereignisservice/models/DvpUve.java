package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.internal.EventSource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.UUID;

@Setter
@Getter
@Embeddable
public class DvpUve implements EventSource {
    @Embedded
    private DVPerson dvPerson;

    @Embedded
    private Sprachnachricht sprachnachricht;
    private Status status;

    private UUID dvpUveId;


    public DvpUve() {
        this.status = Status.ERSTELLT;
        dvpUveId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return this.dvPerson.toString() + ": " + this.status;
    }

    @Override
    @JsonIgnore
    public String getId() {
        return dvpUveId.toString();
    }

    @Override
    @JsonIgnore
    public Long getVersion() {
        //We dont need Versions in this context in my opinion, a tracking event is created once and never updated or altered
        return 1L;
    }

    @Override
    @JsonIgnore
    public String getAggregateName() {
        return "uvereignis";
    }
}
