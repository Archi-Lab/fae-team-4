package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Altitude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Latitude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Longitude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Position;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.AufenthaltsorteRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DvpTest {

    @Autowired
    DvpRepository dvpRepository;
    @Autowired
    AufenthaltsorteRepository aufenthaltsorteRepository;

    @Test
    public void createDVP() {
        DVP dvp = new DVP(UUID.randomUUID(), UUID.randomUUID(), "http://path/to/image");
        DVP savedDvp = dvpRepository.save(dvp);

        assertNotNull(dvp);
        assertEquals(dvp.getId(), savedDvp.getId());
        assertEquals(dvp.getBildUrl(), savedDvp.getBildUrl());
        assertEquals(dvp.getTrackerId(), savedDvp.getTrackerId());
    }

    @Test
    public void createBild() {
        String path = "http://a/b/c";
        Bild bild = new Bild(path);

        assertEquals(path, bild.getBild());
    }

    @Test
    public void createAufenthaltsort(){
        Instant timestamp = Instant.now();
        Aufenthaltsort aufenthaltsort = new Aufenthaltsort(timestamp, new Position(new Latitude(0.0),
                new Longitude(0.0),
                new Altitude(0.0)));
        Aufenthaltsort saved =  aufenthaltsorteRepository.save(aufenthaltsort);
        assertEquals(saved.getPosition().getLatitude().getLatitude(), aufenthaltsort.getPosition().getLatitude().getLatitude(), 0.0);
        assertEquals(saved.getPosition().getLongitude().getLongitude(), aufenthaltsort.getPosition().getLongitude().getLongitude(), 0.0);
        assertEquals(saved.getPosition().getAltitude().getAltitude(), aufenthaltsort.getPosition().getAltitude().getAltitude(), 0.0);
        assertEquals(saved.getTimestamp(), aufenthaltsort.getTimestamp());
    }

    @Test
    public void addAufenthaltsortToDvp(){
        DVP dvp = new DVP(UUID.randomUUID(), UUID.randomUUID(), "http://bild");
        dvpRepository.save(dvp);
        Instant timestamp = Instant.now();

        Aufenthaltsort aufenthaltsort0 =  new Aufenthaltsort(timestamp, new Position(new Latitude(0.0),
                new Longitude(0.0),
                new Altitude(0.0)));
        Aufenthaltsort aufenthaltsort1 =  new Aufenthaltsort(timestamp, new Position(new Latitude(1.0),
                new Longitude(1.0),
                new Altitude(1.0)));
        aufenthaltsorteRepository.save(aufenthaltsort0);
        aufenthaltsorteRepository.save(aufenthaltsort1);

        dvp.addAufenthaltsort(aufenthaltsort0);
        dvp.addAufenthaltsort(aufenthaltsort1);

        DVP savedDvp = dvpRepository.save(dvp);
        Aufenthaltsort as0 = savedDvp.getAufenthaltsorte().get(0);
        Aufenthaltsort as1 = savedDvp.getAufenthaltsorte().get(1);

        assertEquals(as0.getPosition().getLatitude().getLatitude(), aufenthaltsort0.getPosition().getLatitude().getLatitude(), 0.0);
        assertEquals(as0.getPosition().getLongitude().getLongitude(), aufenthaltsort0.getPosition().getLongitude().getLongitude(), 0.0);
        assertEquals(as0.getPosition().getAltitude().getAltitude(), aufenthaltsort0.getPosition().getAltitude().getAltitude(), 0.0);
        assertEquals(as0.getTimestamp(), aufenthaltsort0.getTimestamp());

        assertEquals(as1.getPosition().getLatitude().getLatitude(), aufenthaltsort1.getPosition().getLatitude().getLatitude(), 0.0);
        assertEquals(as1.getPosition().getLongitude().getLongitude(), aufenthaltsort1.getPosition().getLongitude().getLongitude(), 0.0);
        assertEquals(as1.getPosition().getAltitude().getAltitude(), aufenthaltsort1.getPosition().getAltitude().getAltitude(), 0.0);
        assertEquals(as1.getTimestamp(), aufenthaltsort1.getTimestamp());

    }

}
