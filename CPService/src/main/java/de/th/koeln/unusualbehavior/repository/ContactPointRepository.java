package de.th.koeln.unusualbehavior.repository;

import de.th.koeln.unusualbehavior.models.ContactPoint;
import de.th.koeln.unusualbehavior.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPointRepository extends CrudRepository<ContactPoint, Long> {

    Iterable<ContactPoint> findByName(String name);
    Iterable<ContactPoint> findByPosition(Position position);
    Iterable<ContactPoint> findByCityName(String cityName);
    Iterable<ContactPoint> findByZipCode(int zipCode);

}
