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

        /** Neue DVP erstellen, Attribute setzen **/
        final DVPerson dvp = new DVPerson();
        dvp.setDvpId(5);
        dvp.setPosition(position);
        dvp.setBild(new Bild("DVPImageURL.png"));

        /** Neues UVE, mit einem DvpUve erstellen, Attribute setzen **/
        final UVEreignis uvEreignis = new UVEreignis();
        final DvpUve dvpuve = new DvpUve();
        dvpuve.setDvPerson(dvp);
        uvEreignis.addDvpUve(dvpuve);
        uvEreignis.setZeitstempel(new Date());
        uvEreignis.setSprachnachricht(sn);
        dvpuve.setSprachnachricht(sn);

        /** UVE in repo speichern **/
        final UVEreignis savedUVE = uveRepository.save(uvEreignis);
        LOGGER.debug("saved uvEreignis: " + savedUVE.toString());

        /** Test UVE **/
        assertNotNull(savedUVE);
        assertEquals(uvEreignis.getId(), savedUVE.getId());
        assertEquals(uvEreignis.getSprachnachricht().getSprachnachricht(), savedUVE.getSprachnachricht().getSprachnachricht());
        assertEquals(uvEreignis.getZeitstempel(), savedUVE.getZeitstempel());
        assertEquals(uvEreignis.getStatus(), savedUVE.getStatus());

        /** Test DvpUve-Liste **/
        final List<DvpUve> saveddvpuves = savedUVE.getDvpuves();
        assertNotNull(saveddvpuves);
        assertFalse(saveddvpuves.isEmpty()); // DARF ICH DAS SO?
        assertTrue(saveddvpuves.size()== uvEreignis.getDvpuves().size()); // asserEquals geht bei ints doch nicht?

        for (int i = 0; i < saveddvpuves.size(); i++) {
            assertEquals(uvEreignis.getDvpuves().get(i), saveddvpuves.get(i));
        }

        /** Test DVP **/
        final DVPerson savedDVP = saveddvpuves.get(0).getDvPerson();
        assertNotNull(savedDVP);
        assertEquals(dvp, savedDVP);
        assertEquals(dvp.getDvpId(), savedDVP.getDvpId());
        assertEquals(dvp.getBild(), savedDVP.getBild());
        LOGGER.debug("saved dv person: " + savedDVP.toString());

        /** Test Position **/
        final Position savedPosition = savedDVP.getPosition();
        assertNotNull(savedPosition);
        assertEquals(dvp.getPosition(), savedPosition);
        assertEquals(position.getLatitude(), savedPosition.getLatitude());
        assertEquals(position.getLongitude(), savedPosition.getLongitude());

        uveRepository.delete(savedUVE);
        LOGGER.debug("deleted uvEreignis: " + savedUVE.toString());

        assertNull(uveRepository.findById(1));
    }
}

