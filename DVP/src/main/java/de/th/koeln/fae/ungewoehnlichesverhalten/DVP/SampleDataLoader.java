package de.th.koeln.fae.ungewoehnlichesverhalten.DVP;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Bild;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Latitude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Longitude;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Position;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.AufenthaltsorteRepository;
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
    private AufenthaltsorteRepository aufenthaltsorteRepository;

    private String[] bildUrls = {"MaxURL", "PeterURL", "MariaURL", "HansURL", "FrankURL"};

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(aufenthaltsorteRepository.count() > 0)
            return;

       for (int i = 1; i <= 5; i++)
       {
           DVP dvp = new DVP(i);
           dvp.setBild(new Bild(bildUrls[i - 1]));
           this.dvpRepository.save(dvp);

           for (int x = 1; x <= 3; x++)
           {
               Aufenthaltsort ort = new Aufenthaltsort(
                       new Date(),
                       new Position(new Latitude(10 + x + i), new Longitude(25 + x + i)));

               this.aufenthaltsorteRepository.save(ort);

               dvp.AddAufenthaltsort(ort);
           }

           this.dvpRepository.save(dvp);
       }

    }


}
