package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "anlaufstellen", path = "anlaufstellen")
public interface AnlaufstelleRepository extends CrudRepository<Anlaufstelle, Long> {

}
