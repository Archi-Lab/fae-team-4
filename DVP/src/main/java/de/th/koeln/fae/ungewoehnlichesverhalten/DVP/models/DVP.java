package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DVP {

    @Id
    private long dvpId;

    private String bildUrl;

    private String trackerId;

    @OneToMany()
    private List<Aufenthaltsort> aufenthaltsorte;

    public DVP() {

    }

    public DVP(long dvpId) {
        this.dvpId = dvpId;
    }

    public void addAufenthaltsort(Aufenthaltsort ort)
    {
        if(this.aufenthaltsorte == null || this.aufenthaltsorte.isEmpty())
            this.aufenthaltsorte = new ArrayList<>();

        if(ort == null)
            throw new IllegalArgumentException("Ungültiger Ort");

        this.aufenthaltsorte.add(ort);
    }

    // Lombok does not work??
    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }
}
