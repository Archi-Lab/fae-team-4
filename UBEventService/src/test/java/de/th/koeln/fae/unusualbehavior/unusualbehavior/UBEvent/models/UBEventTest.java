package de.th.koeln.fae.unusualbehavior.unusualbehavior.UBEvent.models;

import de.th.koeln.fae.unusualbehavior.unusualbehavior.UBEvent.repositories.UBEventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UBEventTest {

    @Autowired
    private UBEventRepository eventRepository;

    @Test
    public void createPersonExpectCreated(){

        final Position position = new Position();
        position.setLatitude(10);
        position.setLongitude(20);

        final DementedPerson dp = new DementedPerson();
        dp.setDpid(5);
        dp.setPosition(position);
        dp.setImage(new byte[10]);

        final UBEvent event = new UBEvent();
        event.setDvp(dp);
        event.setTimestamp(new Date());
        event.setMessage(new byte[5]);
        event.setAnswer("Answer");

        final UBEvent savedEvent = this.eventRepository.save(event);

        assertNotNull(savedEvent);
        assertNotNull(savedEvent.getId());
        assertEquals(event.getMessage(), savedEvent.getMessage());
        assertEquals(event.getTimestamp(), savedEvent.getTimestamp());
        assertEquals(event.getAnswer(), savedEvent.getAnswer());


        final DementedPerson savedDP =savedEvent.getDp();
        assertNotNull(savedDP);
        assertEquals(dp.getDpid(), savedDP.getDpid());
        assertEquals(dp.getImage(), savedDP.getImage());

        final Position savedPosition =savedDP.getPosition();
        assertNotNull(savedPosition);
        assertEquals(position.getLatitude(), savedPosition.getLatitude(), 0.0);
        assertEquals(position.getLongitude(), savedPosition.getLongitude(), 0.0);
    }
}
