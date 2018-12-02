package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.controller;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Postleitzahl;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "AnlaufstellenProjection", types = {Anlaufstelle.class})
public interface AnlaufstellenProjection {

    /**
     * @see Anlaufstelle#getId()
     * @return
     */
    long getID();

    /**
     * @see Anlaufstelle#getName()
     * @return
     */
    String getName();

    /**
     * @see Anlaufstelle#getAdresse()
     * @return
     */
    String getAdresse();
}
