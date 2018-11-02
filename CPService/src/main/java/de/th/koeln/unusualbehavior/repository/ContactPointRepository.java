package de.th.koeln.unusualbehavior.repository;

import de.th.koeln.unusualbehavior.models.ContactPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPointRepository extends CrudRepository<ContactPoint, Long> {

    Iterable<ContactPoint> findByName(String name);
}
