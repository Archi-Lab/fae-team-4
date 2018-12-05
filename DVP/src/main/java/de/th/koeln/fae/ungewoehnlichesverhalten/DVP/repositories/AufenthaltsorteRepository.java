package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AufenthaltsorteRepository extends CrudRepository<Aufenthaltsort, Long> {
}
