package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DvpRepository extends CrudRepository<DVP, Long> {

    @Override
    Iterable<DVP> findAll();
    Optional<DVP> findById(UUID id);
    Optional<DVP> findByTrackerId(UUID id);
    void deleteById(UUID id);
}
