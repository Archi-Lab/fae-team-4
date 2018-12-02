package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter, Long> {
    Iterable<Mitarbeiter> findByVorname(String vorname);
    Iterable<Mitarbeiter> findByNachname(String nachname);
}

