package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.controller;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Mitarbeiter;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository.AnlaufstelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * REST controller für die Anlaufstellen-Klasse.
 * API-Dokumentation unter: https://github.com/Archi-Lab/fae-team-4/wiki/Konzept-APIs#anlaufstellen
 */
@RepositoryRestController
@RequestMapping("/anlaufstellen")
public class AnlaufstellenController {

    private final AnlaufstelleRepository anlaufstelleRepository;

    @Autowired
    public AnlaufstellenController(AnlaufstelleRepository anlaufstelleRepository) {
        this.anlaufstelleRepository = anlaufstelleRepository;
    }

    /**
     * GET auf alle Anlaufstellen
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getAnlaufstellen() {
        final Iterable<Anlaufstelle> anlaufstellen = this.anlaufstelleRepository.findAll();
        Resources<Anlaufstelle> resources = new Resources<>(anlaufstellen);
        resources.add(linkTo(methodOn(AnlaufstellenController.class).getAnlaufstellen()).withSelfRel());
        return ResponseEntity.ok(resources);
    }

    /**
     * GET Anlaufstelle by id
     * @param aid
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnlaufstelle(@PathVariable("id") long aid) {
        final Optional<Anlaufstelle> anlaufstelle = this.anlaufstelleRepository.findById(aid);
        Resource<Optional<Anlaufstelle>> anlaufstelleResource = new Resource<>(anlaufstelle);
        anlaufstelleResource.add(linkTo(methodOn(AnlaufstellenController.class).getAnlaufstelle(aid)).withSelfRel());
        return ResponseEntity.ok(anlaufstelleResource);
    }

    //TODO POST /anlaufstellen

    //TODO PUT /anlaufstellen/{id}

    //TODO DELETE /anlaufstellen/{id}

    @GetMapping("/{aid}/mitarbeiter")
    public ResponseEntity<?> getAnlaufstellenMitarbeiter(@PathVariable("aid") long aid) {
        final Iterable<Mitarbeiter> mitarbeiter = this.anlaufstelleRepository.findById(aid).get().getMitarbeiterListe();
        Resources<Mitarbeiter> mitarbeiterResource = new Resources<>(mitarbeiter);
        mitarbeiterResource.add(linkTo(methodOn(AnlaufstellenController.class).getAnlaufstellenMitarbeiter(aid)).withSelfRel());
        return ResponseEntity.ok(mitarbeiterResource);
    }

    //TODO POST /anlaufstellen/{aId}/mitarbeiter

    //TODO PUT /anlaufstellen/{aId}/mitarbeiter/{mId}

    //TODO DELETE /anlaufstellen/{aId}/mitarbeiter/{mId}
}
