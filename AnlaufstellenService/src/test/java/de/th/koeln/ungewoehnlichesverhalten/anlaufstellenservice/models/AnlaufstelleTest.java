package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;


import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address.*;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo.Latitude;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo.Longitude;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo.Position;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person.Nachname;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person.Vorname;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository.AnlaufstelleRepository;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnlaufstelleTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(AnlaufstelleTest.class);

    @Autowired
    private AnlaufstelleRepository anlaufstelleRepository;

    @Test
    public void createContactPointExpectedCreated(){

        Adresse gummersbach = new Adresse(
                new Postleitzahl("51061"),
                new Stadt("Gummersbach"),
                new Straße("Hohe Straße"),
                new Hausnummer("10"),
                new Position(
                        new Latitude(50.192),
                        new Longitude(7.65)));

        Anlaufstelle anlaufstelle = new Anlaufstelle(
                new AnlaufstellenName("Penny"),
                gummersbach);

        anlaufstelle.getMitarbeiter().add(
                new Mitarbeiter(
                        new Vorname("Peter"),
                        new Nachname("Müller")));

        anlaufstelle.getMitarbeiter().add(
                new Mitarbeiter(
                        new Vorname("Max"),
                        new Nachname("Mustermann")));

        anlaufstelle.getMitarbeiter().add(
                new Mitarbeiter(
                        new Vorname("Tim"),
                        new Nachname("Turm")));

        Anlaufstelle saved = anlaufstelleRepository.save(anlaufstelle);

        LOGGER.info("Anlaufstelle to save:");
        LOGGER.info(anlaufstelle.toString());

        assertNotNull(saved);
        assertNotNull(saved.getId());

        // Name
        assertEquals(anlaufstelle.getName().getName(), saved.getName().getName());

        // Position
        assertEquals(anlaufstelle.getAdresse().getPosition().getLatitude().getLatitude(), saved.getAdresse().getPosition().getLatitude().getLatitude(), 0);
        assertEquals(anlaufstelle.getAdresse().getPosition().getLongitude().getLongitude(), saved.getAdresse().getPosition().getLongitude().getLongitude(), 0);

        // Adresse
        assertEquals(anlaufstelle.getAdresse().getPostleitzahl().getPlz(), saved.getAdresse().getPostleitzahl().getPlz());
        assertEquals(anlaufstelle.getAdresse().getStadt().getStadt(), saved.getAdresse().getStadt().getStadt());
        assertEquals(anlaufstelle.getAdresse().getHausnummer().getHausnummer(), saved.getAdresse().getHausnummer().getHausnummer());
        assertEquals(anlaufstelle.getAdresse().getStraße().getStraße(), saved.getAdresse().getStraße().getStraße());

        // Mitarbeiter 1
        assertEquals(anlaufstelle.getMitarbeiter().get(0).getVorname().getVorname(), saved.getMitarbeiter().get(0).getVorname().getVorname());
        assertEquals(anlaufstelle.getMitarbeiter().get(0).getNachname().getNachname(), saved.getMitarbeiter().get(0).getNachname().getNachname());

        // Mitarbeiter 2
        assertEquals(anlaufstelle.getMitarbeiter().get(1).getVorname().getVorname(), saved.getMitarbeiter().get(1).getVorname().getVorname());
        assertEquals(anlaufstelle.getMitarbeiter().get(1).getNachname().getNachname(), saved.getMitarbeiter().get(1).getNachname().getNachname());

        // Mitarbeiter 3
        assertEquals(anlaufstelle.getMitarbeiter().get(2).getVorname().getVorname(), saved.getMitarbeiter().get(2).getVorname().getVorname());
        assertEquals(anlaufstelle.getMitarbeiter().get(2).getNachname().getNachname(), saved.getMitarbeiter().get(2).getNachname().getNachname());

        LOGGER.info("Anlaufstelle was saved:");
        LOGGER.info(saved.toString());

        anlaufstelleRepository.delete(saved);

        LOGGER.info("Anlaufstelle deleted");
    }
}
