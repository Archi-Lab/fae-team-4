package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models;


import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UVEreignisTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UVEreignisTest.class);

    @Autowired
    private UVEreignisRepository eventRepository;

    @Test
    public void createPersonExpectCreated(){

        final Position position = new Position(10, 20);

        final DVPerson dp = new DVPerson();
        dp.setId(5);
        dp.setPosition(position);
        dp.setBild(new byte[10]);

        final UVEreignis event = new UVEreignis();
        event.setDVPerson(dp);
        event.setZeitstempel(new Date());
        event.setSprachnachricht(new Sprachnachricht(new byte[5]));
        event.setDankenachricht(new Dankenachricht("Answer"));

        final UVEreignis savedEvent = eventRepository.save(event);
        LOGGER.debug("saved event: " + savedEvent.toString());

        assertNotNull(savedEvent);
        assertNotNull(savedEvent.getId());
        assertEquals(event.getSprachnachricht().getSprachnachricht(), savedEvent.getSprachnachricht().getSprachnachricht());
        assertEquals(event.getZeitstempel(), savedEvent.getZeitstempel());
        assertEquals(event.getDankenachricht().getNachricht(), savedEvent.getDankenachricht().getNachricht());


        final DVPerson savedDP = savedEvent.getDVPerson();
        assertNotNull(savedDP);
        assertEquals(dp.getId(), savedDP.getId());
        assertEquals(dp.getBild(), savedDP.getBild());
        LOGGER.debug("saved dv person: " + savedDP.toString());

        final Position savedPosition = savedDP.getPosition();
        assertNotNull(savedPosition);
        assertEquals(position.getLatitude(), savedPosition.getLatitude(), 0.0);
        assertEquals(position.getLongitude(), savedPosition.getLongitude(), 0.0);

        eventRepository.delete(savedEvent);
        LOGGER.debug("deleted event: " + savedEvent.toString());

        assertNull(eventRepository.findById(1));
    }
}

