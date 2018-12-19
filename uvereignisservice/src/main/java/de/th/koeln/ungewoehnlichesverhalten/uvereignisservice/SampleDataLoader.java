package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.*;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.services.DvpUvePublisher;
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

        if(ereigbnisRepository.count() > 0)
            return;

        // Testposition erstellen
        Position position = new Position(10, 20);

        // DVP 1 erstellen
        DVPerson dp1 = new DVPerson();
        dp1.setDvpId(5);
        dp1.setPosition(position);
        dp1.setBild(new byte[10]);

        // DVP 2 erstellen
        DVPerson dp2 = new DVPerson();
        dp2.setDvpId(6);
        dp2.setPosition(position);
        dp2.setBild(new byte[10]);

        // UVEreignis 1 erstellen
        UVEreignis uve1 = new UVEreignis();
        uve1.setZeitstempel(new Date());
        uve1.setSprachnachricht(new Sprachnachricht(new byte[5]));
        //uve1.setDankenachricht(new Dankenachricht("Answer")); Gibts nicht mehr --> Wird generiert, wenn UVE status = behoben

        DvpUve dvpUve1 = new DvpUve();
        dvpUve1.setDvPerson(dp1);
        dvpUve1.setSprachnachricht(new Sprachnachricht(new byte[5]));
        uve1.addDvpUve(dvpUve1);

        DvpUve dvpUve2 = new DvpUve();
        dvpUve2.setDvPerson(dp2);
        dvpUve2.setSprachnachricht(new Sprachnachricht(new byte[5]));
        uve1.addDvpUve(dvpUve2);

        // UVEreignis 2 erstellen
        UVEreignis uve2 = new UVEreignis();
        uve2.setZeitstempel(new Date());
        uve2.setSprachnachricht(new Sprachnachricht(new byte[5]));
        //uve2.setDankenachricht(new Dankenachricht("Answer")); Gibts nicht mehr --> Wird generiert, wenn UVE status = behoben

        DvpUve dvpUve3 = new DvpUve();
        dvpUve3.setDvPerson(dp1);
        dvpUve3.setStatus(Status.BEHOBEN);
        dvpUve3.setSprachnachricht(new Sprachnachricht(new byte[5]));
        uve2.addDvpUve(dvpUve3);

        DvpUve dvpUve4 = new DvpUve();
        dvpUve4.setDvPerson(dp2);
        dvpUve4.setStatus(Status.BEHOBEN);
        dvpUve4.setSprachnachricht(new Sprachnachricht(new byte[5]));
        uve2.addDvpUve(dvpUve4);

        ereigbnisRepository.save(uve1);
        ereigbnisRepository.save(uve2);
    }
}
