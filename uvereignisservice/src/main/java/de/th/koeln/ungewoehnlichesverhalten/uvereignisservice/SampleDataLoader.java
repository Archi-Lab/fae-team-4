package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.*;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UVEreignisRepository ereigbnisRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final Position position = new Position(10, 20);

        final DVPerson dp = new DVPerson();
        dp.setId(5);
        dp.setPosition(position);
        dp.setBild(new byte[10]);

        final UVEreignis ereignis = new UVEreignis();
        ereignis.setDVPerson(dp);
        ereignis.setZeitstempel(new Date());
        ereignis.setSprachnachricht(new Sprachnachricht(new byte[5]));
        ereignis.setDankenachricht(new Dankenachricht("Answer"));

        ereigbnisRepository.save(ereignis);
    }
}
