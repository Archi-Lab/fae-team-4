package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.geo.Latitude;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.geo.Longitude;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.geo.Position;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.services.DvpUvePublisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@Component
public class UVEreignisTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UVEreignisTest.class);

    @Autowired
    private UVEreignisRepository uveRepository;

    @Autowired
    private DvpUvePublisher dvpUvePublisher;

    @Test
    public void publishKafkaEvents() {
        UVEreignis firstUVE = uveRepository.findAll().iterator().next();
        dvpUvePublisher.sendeUVEreignis(firstUVE);
    }

    @Test
    public void createPersonExpectCreated(){

        Position position = new Position(new Latitude(10), new Longitude(20));
        Sprachnachricht sn = new Sprachnachricht(new byte[5]);

        /* Neue DVP erstellen, Attribute setzen **/
        final DVPerson dvp = new DVPerson();
        dvp.dvpId = 5;
        dvp.position = position;
        dvp.bild = new Bild("DVPImageURL.png");

        /* Neues UVE, mit einem DvpUve erstellen, Attribute setzen **/
        final UVEreignis uvEreignis = new UVEreignis();
        final DvpUve dvpuve = new DvpUve();
        dvpuve.dvPerson = dvp;
        uvEreignis.addDvpUve(dvpuve);
        uvEreignis.zeitstempel = new Date();
        dvpuve.sprachnachricht = sn;

        /* UVE in repo speichern **/
        final UVEreignis savedUVE = uveRepository.save(uvEreignis);
        LOGGER.debug("saved uvEreignis: " + savedUVE.toString());

        /* Test UVE **/
        assertNotNull(savedUVE);
        assertEquals(uvEreignis.id, savedUVE.id);
        assertEquals(uvEreignis.zeitstempel, savedUVE.zeitstempel);
        assertEquals(uvEreignis.status, savedUVE.status);

        /* Test DvpUve-Liste **/
        final List<DvpUve> saveddvpuves = savedUVE.dvpuves;
        assertNotNull(saveddvpuves);
        assertFalse(saveddvpuves.isEmpty()); // DARF ICH DAS SO?
        assertTrue(saveddvpuves.size()== uvEreignis.dvpuves.size()); // asserEquals geht bei ints doch nicht?

        for (int i = 0; i < saveddvpuves.size(); i++) {
            assertEquals(uvEreignis.dvpuves.get(i), saveddvpuves.get(i));
        }

        /* Test DVP **/
        final DVPerson savedDVP = saveddvpuves.get(0).dvPerson;
        assertNotNull(savedDVP);
        assertEquals(dvp, savedDVP);
        assertEquals(dvp.dvpId, savedDVP.dvpId);
        assertEquals(dvp.bild, savedDVP.bild);
        LOGGER.debug("saved dv person: " + savedDVP.toString());

        /* Test Position **/
        final Position savedPosition = savedDVP.position;
        assertNotNull(savedPosition);
        assertEquals(dvp.position, savedPosition);
        assertEquals(position.latitude, savedPosition.latitude);
        assertEquals(position.longitude, savedPosition.longitude);

        uveRepository.delete(savedUVE);
        LOGGER.debug("deleted uvEreignis: " + savedUVE.toString());

        assertNull(uveRepository.findById(1));
    }
}

