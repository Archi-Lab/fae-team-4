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

    @Embedded
    private Bild bild;

    @Embedded
    private Tracker tracker;

    @OneToMany()
    private List<Aufenthaltsort> aufenthaltsorte;

    public DVP(long dvpId) {
        this.dvpId = dvpId;
    }

    public void AddAufenthaltsort(Aufenthaltsort ort)
    {
        if(this.aufenthaltsorte == null || this.aufenthaltsorte.isEmpty())
            this.aufenthaltsorte = new ArrayList<>();

        if(ort == null)
            throw new IllegalArgumentException("Ungültiger Ort");

        this.aufenthaltsorte.add(ort);
    }

}
