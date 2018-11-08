package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models;


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

        Anlaufstelle anlaufstelle = new Anlaufstelle();
        anlaufstelle.setName("Penny");

        Position position = new Position();
        position.setKoordinaten(50.192, 7.65);
        anlaufstelle.setPosition(position);
        anlaufstelle.setStadt("Köln");
        anlaufstelle.setPostleitzahl(new Postleitzahl("51061"));
        anlaufstelle.setAdresse(new Adresse("Hohe Straße",  "13"));

        Mitarbeiter mitarbeiter = new Mitarbeiter();
        mitarbeiter.setVorname("Peter");
        mitarbeiter.setName("Müller");

        Mitarbeiter mitarbeiter1 = new Mitarbeiter();
        mitarbeiter1.setVorname("Max");
        mitarbeiter1.setName("Mustermann");

        ArrayList<Mitarbeiter> mitarbeiterArrayList = new ArrayList<>();
        mitarbeiterArrayList.add(mitarbeiter);
        mitarbeiterArrayList.add(mitarbeiter1);

        anlaufstelle.setMitarbeiterListe(mitarbeiterArrayList);

        Anlaufstelle anlaufstelleSaved = anlaufstelleRepository.save(anlaufstelle);

        LOGGER.info("Anlaufstelle to save:");
        LOGGER.info(anlaufstelle.toString());

        assertNotNull(anlaufstelleSaved);
        assertNotNull(anlaufstelleSaved.getId());
        assertEquals(anlaufstelle.getName(), anlaufstelleSaved.getName());
        assertEquals(position.getLatitude(), anlaufstelleSaved.getPosition().getLatitude(), 0);
        assertEquals(position.getLongitude(), anlaufstelleSaved.getPosition().getLongitude(), 0);
        assertEquals(anlaufstelle.getAdresse().getStrasse(), anlaufstelleSaved.getAdresse().getStrasse());
        assertEquals(anlaufstelle.getStadt(), anlaufstelleSaved.getStadt());
        assertThat(anlaufstelleSaved.getMitarbeiterListe(), IsIterableContainingInOrder.contains((mitarbeiterArrayList.toArray())));

        LOGGER.info("Anlaufstelle was saved:");
        LOGGER.info(anlaufstelleSaved.toString());

        anlaufstelleRepository.delete(anlaufstelleSaved);

        LOGGER.info("Anlaufstelle deleted");
    }
}
