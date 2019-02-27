package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Klasse für das Ungewöhnliche Verhalten Ereignis (UVE) welches nach Meldung durch die MAS erstellt wird und kann mehrere DVPs beinhalten
 * id enthält die eindeutige ID des Ereignisses
 * dvpuves enthält die Liste der DvpUves (siehe Klasse DvpUve)
 * zeitstempel enthält den Zeitstempel des Meldens durch die MAS
 * sprachnachricht enthält die Sprachnachricht
 * status enthält den aktuellen Status des UVE
 */
@Entity
@Setter
@Getter
public class UVEreignis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ElementCollection(targetClass = DvpUve.class)
    List<DvpUve> dvpuves = new ArrayList<>();

    @Embedded
    Date zeitstempel;
    Status status;


    public UVEreignis(){
        this.status = Status.ERSTELLT;
    }

    /**
     * Der Status eines UV-Ereignisses wird in Abhängigkeit von den Stati der enthaltenen DvpUves berechnet
     */
    public void berechneStatus() {
        if (dvpuves.size() == 0) {
            status = Status.values()[0];
        } else {
            Status neuerStatus = Status.values()[Status.values().length-1];
            for (DvpUve dvpUve : dvpuves) {
                if (dvpUve.status.ordinal() < neuerStatus.ordinal()) {
                    neuerStatus = dvpUve.status;
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

