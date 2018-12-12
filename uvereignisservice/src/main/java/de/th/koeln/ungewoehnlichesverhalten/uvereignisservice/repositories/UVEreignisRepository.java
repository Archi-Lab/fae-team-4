package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "uvereignisse", path = "uvereignisse")
public interface UVEreignisRepository extends CrudRepository<UVEreignis, Long> {
    @Override
    Iterable<UVEreignis> findAll();
    Optional<UVEreignis> findById(long id);
    // Müssen die obigen 3 Zeilen auch weg?
}