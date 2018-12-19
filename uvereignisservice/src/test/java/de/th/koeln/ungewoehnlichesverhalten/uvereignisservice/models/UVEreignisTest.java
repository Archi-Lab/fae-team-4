package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@Component
public class UVEreignisTest {

    private static final Logger log = LoggerFactory.getLogger(UVEreignisTest.class);

    @Autowired
    private UVEreignisRepository uveRepository;

    /*@Autowired
    private DvpUvePublisher dvpUvePublisher;*/

    /*@Test
    public void publishKafkaEvents() {
        UVEreignis firstUVE = uveRepository.findAll().iterator().next();
        dvpUvePublisher.sendeUVEreignis(firstUVE);
    }*/

    @Test
    public void createPersonExpectCreated(){

        /*final Position position = new Position(10, 20);

        final DVPerson dvp = new DVPerson();
        dvp.setDvpId(5);
        dvp.setPosition(position);
        dvp.setBild(new byte[10]);

        final DvpUve dvpuve = new DvpUve(); //TODO hier noch nen DVP rein machen

        final UVEreignis uvEreignis = new UVEreignis();
        uvEreignis.addDvpUve(dvpuve);
        uvEreignis.setZeitstempel(new Date());
        uvEreignis.setSprachnachricht(new Sprachnachricht(new byte[5]));

        final UVEreignis savedUVE = UVERepository.save(uvEreignis);
        LOGGER.debug("saved uvEreignis: " + savedUVE.toString());

        assertNotNull(savedUVE);
        assertNotNull(savedUVE.getId());
        assertEquals(uvEreignis.getSprachnachricht().getSprachnachricht(), savedUVE.getSprachnachricht().getSprachnachricht());
        assertEquals(uvEreignis.getZeitstempel(), savedUVE.getZeitstempel());


        final DVPerson savedDVP = savedUVE.getDVPerson(); //TODO get DVPUVE Liste
        assertNotNull(savedDVP);
        assertEquals(dvp.getDpId(), savedDVP.getDpId());
        assertEquals(dvp.getBild(), savedDVP.getBild());
        LOGGER.debug("saved dv person: " + savedDVP.toString());

        final Position savedPosition = savedDVP.getPosition();
        assertNotNull(savedPosition);
        assertEquals(position.getLatitude(), savedPosition.getLatitude(), 0.0);
        assertEquals(position.getLongitude(), savedPosition.getLongitude(), 0.0);

        UVERepository.delete(savedUVE);
        LOGGER.debug("deleted uvEreignis: " + savedUVE.toString());

        assertNull(UVERepository.findById(1));*/
    }
}

