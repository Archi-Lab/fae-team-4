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

        Position position = new Position(10, 20);

        DVPerson dp = new DVPerson();
        dp.setDpId(5);
        dp.setPosition(position);
        dp.setBild(new byte[10]);

        UVEreignis uve1 = new UVEreignis();
        //uve1.setDVPerson(dp); Hier set auf DVPUVE
        uve1.setZeitstempel(new Date());
        uve1.setSprachnachricht(new Sprachnachricht(new byte[5]));
        //uve1.setDankenachricht(new Dankenachricht("Answer")); Gibts nicht mehr --> Wird generiert, wenn UVE status = behoben

        ereigbnisRepository.save(uve1);
    }
}
