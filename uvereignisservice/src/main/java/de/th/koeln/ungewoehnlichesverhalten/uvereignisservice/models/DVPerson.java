package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.geo.Position;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;


/**
 * Klasse für Dementiell Veränderte Personen (DVP)
 * bildUrl enthält die URL zum Profilbild der DVP
 * position enthält die GPS Position der DVP
 */
@Embeddable
@Setter
@Getter
public class DVPerson {
    private long dvpId;

    @Embedded
    private Bild bild;

    @Embedded
    private Position position;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
