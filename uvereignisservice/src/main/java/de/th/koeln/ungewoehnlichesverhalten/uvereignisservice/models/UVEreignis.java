package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class UVEreignis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    @JoinColumn(name = "uvereignis_id")
    private List<DvpUve> dvpuveListe = new ArrayList<>();

    @Embedded
    private Sprachnachricht sprachnachricht;
    private Date zeitstempel;
    private Status status;

    public UVEreignis(){
        this.status = Status.ERSTELLT;
    }
    public void setStatus(Status status) { //Überschreibt automatisch den von LomBok generierten setter :)
        this.status = status;
        //TODO Bei Änderung des Status: entsprechende Aktion ausführen
    }

    public void addDvpUve(DvpUve dvpuve){
        this.dvpuveListe.add(dvpuve);
    }

    @Override
    public String toString(){
        return this.zeitstempel + ": " + this.status;
    } //TODO Hier noch die Liste mit den DVPUVEs durchgeben
    // for(int i = 0 ; i < this.dvpuveListe.size(); i++){ this.dvpuveListe.get(i).getDvp();} //Oder so
}

