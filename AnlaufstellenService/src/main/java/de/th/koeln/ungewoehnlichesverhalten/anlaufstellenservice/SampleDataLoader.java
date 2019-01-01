package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice;


import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.*;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.address.*;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.geo.*;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.person.*;
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

        Mitarbeiter max = new Mitarbeiter(new Vorname("Max"), new Nachname("Mustermann"));
        Mitarbeiter erika = new Mitarbeiter(new Vorname("Erika"),new Nachname("Mustermann"));
        Mitarbeiter heinz = new Mitarbeiter(new Vorname("Heinz"), new Nachname("Mustermann"));
        Mitarbeiter erik = new Mitarbeiter(new Vorname("Erik"), new Nachname("Mustermann"));
        List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
        mitarbeiterList.add(max);
        mitarbeiterList.add(erika);
        mitarbeiterList.add(erik);
        mitarbeiterList.add(heinz);


        List<Anlaufstelle> anlaufstellen = new ArrayList<>();

        Anlaufstelle as1 = new Anlaufstelle();
        as1.setName("TH Köln, Campus Gummersbach");
        as1.setAdresse(
                new Adresse(
                        new Postleitzahl("51643"),
                        new Stadt("Gummersbach"),
                        new Straße("Steinmüllerallee"),
                        new Hausnummer("1"),
                        new Position(new Latitude(51.022458), new Longitude(7.562683))));

        as1.setMitarbeiter(mitarbeiterList);

        Anlaufstelle as2 = new Anlaufstelle();
        as2.setName("Forum Gummersbach");
        as2.setAdresse(
                new Adresse(
                        new Postleitzahl("51643"),
                        new Stadt("Gummersbach"),
                        new Straße("Steinmüllerallee"),
                        new Hausnummer("5"),
                        new Position(new Latitude(51.025178), new Longitude(7.565437))));

        Anlaufstelle as3 = new Anlaufstelle();
        as3.setName("SCHWALBE Arena");
        as3.setAdresse(
                new Adresse(
                        new Postleitzahl("51643"),
                        new Stadt("Gummersbach"),
                        new Straße("Heiner-Brand-Platz"),
                        new Hausnummer("1"),
                        new Position(new Latitude(51.024949), new Longitude(7.562937))));

        Anlaufstelle as4 = new Anlaufstelle();
        as4.setName("Deutsche Bank");
        as4.setAdresse(
                new Adresse(
                        new Postleitzahl("51643"),
                        new Stadt("Gummersbach"),
                        new Straße("Hindenburgstraße"),
                        new Hausnummer("21-25"),
                        new Position(new Latitude(51.025272), new Longitude(7.567948))));

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