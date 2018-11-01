package de.th.koeln.fae.unusualbehavior.unusualbehavior.UBEvent.repositories;

import de.th.koeln.fae.unusualbehavior.unusualbehavior.UBEvent.models.UBEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UBEventRepository extends CrudRepository<UBEvent, Long> {
}
