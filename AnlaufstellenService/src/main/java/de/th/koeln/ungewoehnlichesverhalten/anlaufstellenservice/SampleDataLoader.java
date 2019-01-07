package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice;


import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Adresse;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Mitarbeiter;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Postleitzahl;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository.AnlaufstelleRepository;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository.MitarbeiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AnlaufstelleRepository anlaufstelleRepository;

    @Autowired
    private MitarbeiterRepository mitarbeiterRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if(anlaufstelleRepository.count() > 0)
            return;

        Mitarbeiter max = new Mitarbeiter("Max", "Mustermann");
        Mitarbeiter erika = new Mitarbeiter("Erika","Mustermann");
        Mitarbeiter heinz = new Mitarbeiter("Heinz", "Mustermann");
        Mitarbeiter erik = new Mitarbeiter("Erik", "Mustermann");
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        mitarbeiterList.add(max);
        mitarbeiterList.add(erika);
        mitarbeiterList.add(erik);
        mitarbeiterList.add(heinz);


        List<Anlaufstelle> anlaufstellen = new ArrayList<>();
        Postleitzahl plzGummersbach = new Postleitzahl("51643");

        Anlaufstelle as1 = new Anlaufstelle();
        as1.setName("TH Köln, Campus Gummersbach");
        as1.setAdresse(new Adresse("Steinmüllerallee", "1"));
        as1.setPostleitzahl(plzGummersbach);
        as1.setStadt("Gummersbach");
        as1.setMitarbeiter(mitarbeiterList);

        Anlaufstelle as2 = new Anlaufstelle();
        as2.setName("Forum Gummersbach");
        as2.setAdresse(new Adresse("Steinmüllerallee", "5"));
        as2.setPostleitzahl(plzGummersbach);
        as2.setStadt("Gummersbach");

        Anlaufstelle as3 = new Anlaufstelle();
        as3.setName("SCHWALBE Arena");
        as3.setAdresse(new Adresse("Heiner-Brand-Platz", "1"));
        as3.setPostleitzahl(plzGummersbach);
        as3.setStadt("Gummersbach");

        Anlaufstelle as4 = new Anlaufstelle();
        as4.setName("Deutsche Bank");
        as4.setAdresse(new Adresse("Hindenburgstraße", "21-25"));
        as4.setPostleitzahl(plzGummersbach);
        as4.setStadt("Gummersbach");

        // Save stuff
        this.mitarbeiterRepository.save(erik);
        this.mitarbeiterRepository.save(erika);
        this.mitarbeiterRepository.save(heinz);
        this.mitarbeiterRepository.save(max);
        this.anlaufstelleRepository.save(as1);
        this.anlaufstelleRepository.save(as2);
        this.anlaufstelleRepository.save(as3);
        this.anlaufstelleRepository.save(as4);

    }
}