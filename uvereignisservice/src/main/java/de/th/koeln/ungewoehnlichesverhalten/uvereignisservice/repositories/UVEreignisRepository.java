package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UVEreignisRepository extends CrudRepository<UVEreignis, Long> {
    @Override
    Iterable<UVEreignis> findAll();
    Iterable<UVEreignis> findById(long id);
}
