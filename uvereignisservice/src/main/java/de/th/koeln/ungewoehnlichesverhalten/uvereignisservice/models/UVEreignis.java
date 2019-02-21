package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.events.DvpUveEvent;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.infrastructure.eventing.internal.KafkaGateway;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Entity
@Setter
@Getter
public class UVEreignis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ElementCollection(targetClass = DvpUve.class)
    private List<DvpUve> dvpuves = new ArrayList<>();

    @Embedded
    private Sprachnachricht sprachnachricht; // TODO Sprachnachricht nur im UVE oder DVP-UVE?
    private Date zeitstempel;
    private Status status;


    public UVEreignis(){
        this.status = Status.ERSTELLT;
    }

    /**
     * Der Status eines UV-Ereignisses wird in Abhängigkeit von den Stati der enthaltenen DvpUves berechnet
     */
    public void berechneStatus() {
        // status auf basis von dvpuves neu berechnen
        if (dvpuves.size() == 0) {
            status = Status.values()[0];
        } else {
            Status neuerStatus = Status.values()[Status.values().length-1];
            for (DvpUve dvpUve : dvpuves) {
                if (dvpUve.getStatus().ordinal() < neuerStatus.ordinal()) {
                    neuerStatus = dvpUve.getStatus();
                }
            }
            status = neuerStatus;
        }
    }

    /**
     * Es wird ein neues DvpUve hinzugefügt und der Status neu berechnet
     */
    public void addDvpUve(DvpUve dvpuve){
        this.dvpuves.add(dvpuve);
        berechneStatus();
    }

    /**
     * Es wird ein DvpUve entfernt und der Status neu berechnet
     */
    public void removeDvpUve(DvpUve dvpuve){
        this.dvpuves.remove(dvpuve);
        berechneStatus();
    }

    @Override
    public String toString(){
        String ergebnis = this.zeitstempel + ": " + this.status;
        ergebnis += "\nDvpUves: \n";
        for (DvpUve dvpUve : dvpuves) {
            ergebnis += dvpUve.toString() + "\n";
        }
        return ergebnis;
    }
}

