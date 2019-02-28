package de.th.koeln.fae.ungewoehnlichesverhalten.DVP;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.AufenthaltsorteRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private DvpRepository dvpRepository;
//
//    @Autowired
//    private AufenthaltsorteRepository aufenthaltsorteRepository;
//
//    private String[] bildUrls = {"MaxURL", "PeterURL", "MariaURL", "HansURL", "FrankURL"};
//
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//
//        if(aufenthaltsorteRepository.count() > 0)
//            return;

//       for (int i = 1; i <= 5; i++)
//       {
//           DVP dvp = new DVP(i);
//           dvp.setBildUrl(bildUrls[i-1]);
//           this.dvpRepository.save(dvp);
//
//           for (int x = 1; x <= 3; x++)
//           {
//               Aufenthaltsort ort = new Aufenthaltsort(new Date(), new Position(10 + x + i, 25 + x + i));
//
//               this.aufenthaltsorteRepository.save(ort);
//
//               dvp.addAufenthaltsort(ort);
//           }
//
//           this.dvpRepository.save(dvp);
//       }
    }


}
