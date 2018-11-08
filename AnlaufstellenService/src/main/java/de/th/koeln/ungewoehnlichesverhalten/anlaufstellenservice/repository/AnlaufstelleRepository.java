package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Position;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Postleitzahl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnlaufstelleRepository extends CrudRepository<Anlaufstelle, Long> {

    Iterable<Anlaufstelle> findByName(String name);
    Iterable<Anlaufstelle> findByPosition(Position position);
    Iterable<Anlaufstelle> findByStadt(String cityName);
    Iterable<Anlaufstelle> findByPostleitzahl(Postleitzahl postleitzahl);

}
