package de.th.koeln.fae.ungewoehnlichesverhalten.DVP;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Position;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.AufenthalsorteRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.CustomDvpRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DvpRepository dvpRepository;

    @Autowired
    private AufenthalsorteRepository aufenthalsorteRepository;

    @Autowired
    private CustomDvpRepository customDvpRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

       for (int i = 1; i <= 5; i++)
       {
           DVP dvp = new DVP(i);
           this.dvpRepository.save(dvp);

           for (int x = 1; x <= 3; x++)
           {
               Aufenthaltsort ort = new Aufenthaltsort(new Date(), new Position(10 + x + i, 25 + x + i));

               this.aufenthalsorteRepository.save(ort);

               dvp.AddAufenthaltsort(ort);
           }

           this.dvpRepository.save(dvp);
       }

    }
}
