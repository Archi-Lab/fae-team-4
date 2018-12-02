package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice;


import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Adresse;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Mitarbeiter;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Postleitzahl;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository.AnlaufstelleRepository;
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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<Anlaufstelle> anlaufstellen = new ArrayList<>();
        Postleitzahl plzGummersbach = new Postleitzahl("51643");

        Anlaufstelle as1 = new Anlaufstelle();
        as1.setName("TH Köln, Campus Gummersbach");
        as1.setAdresse(new Adresse("Steinmüllerallee", "1"));
        as1.setPostleitzahl(plzGummersbach);
        as1.setStadt("Gummersbach");
        as1.addMitarbeiter(new Mitarbeiter("Max", "Mustermann"));
        this.anlaufstelleRepository.save(as1);

        Anlaufstelle as2 = new Anlaufstelle();
        as2.setName("Forum Gummersbach");
        as2.setAdresse(new Adresse("Steinmüllerallee", "5"));
        as2.setPostleitzahl(plzGummersbach);
        as2.setStadt("Gummersbach");
        as2.addMitarbeiter(new Mitarbeiter("Erika", "Mustermann"));
        this.anlaufstelleRepository.save(as2);

        Anlaufstelle as3 = new Anlaufstelle();
        as3.setName("SCHWALBE Arena");
        as3.setAdresse(new Adresse("Heiner-Brand-Platz", "1"));
        as3.setPostleitzahl(plzGummersbach);
        as3.setStadt("Gummersbach");
        as3.addMitarbeiter(new Mitarbeiter("Erik", "Mustermann"));
        this.anlaufstelleRepository.save(as3);

        Anlaufstelle as4 = new Anlaufstelle();
        as4.setName("Deutsche Bank");
        as4.setAdresse(new Adresse("Hindenburgstraße", "21-25"));
        as4.setPostleitzahl(plzGummersbach);
        as4.setStadt("Gummersbach");
        as4.addMitarbeiter(new Mitarbeiter("Petra", "Mustermann"));
        this.anlaufstelleRepository.save(as4);
    }
}