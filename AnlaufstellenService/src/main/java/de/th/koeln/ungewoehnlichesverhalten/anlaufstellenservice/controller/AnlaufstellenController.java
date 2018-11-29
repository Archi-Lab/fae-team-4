package de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.controller;

import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Anlaufstelle;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.models.Mitarbeiter;
import de.th.koeln.ungewoehnlichesverhalten.anlaufstellenservice.repository.AnlaufstelleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(AnlaufstellenController.class);

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
        LOGGER.info("GET alle Anlaufstellen");
        return ResponseEntity.ok(resources);
    }

    /**
     * GET Anlaufstelle by id
     * @param aid
     * @return
     */
    @GetMapping("/{aid}")
    public ResponseEntity<?> getAnlaufstelle(@PathVariable("aid") long aid) {
        final Optional<Anlaufstelle> anlaufstelle = this.anlaufstelleRepository.findById(aid);
        Resource<Optional<Anlaufstelle>> anlaufstelleResource = new Resource<>(anlaufstelle);
        anlaufstelleResource.add(linkTo(methodOn(AnlaufstellenController.class).getAnlaufstelle(aid)).withSelfRel());
        LOGGER.info("GET Anlaufstelle {}", aid);
        return ResponseEntity.ok(anlaufstelleResource);
    }

    /**
     * POST Anlaufstelle
     * @param anlaufstelle
     * @return
     */
    @PostMapping()
    public ResponseEntity<?> postAnlaufstelle(@RequestBody Anlaufstelle anlaufstelle) {
        LOGGER.info("POST Anlaufstelle");
        return new ResponseEntity<>(anlaufstelleRepository.save(anlaufstelle), HttpStatus.CREATED);
    }


    /**
     * PUT Anlaufstelle, zum Updaten
     * @param aid ID der Anlaufstelle
     * @return
     */
    @PutMapping("/{aid}")
    public ResponseEntity<?> putAnlaufstelle(@PathVariable("aid") long aid, @RequestBody Anlaufstelle anlaufstelle) {
       Optional<Anlaufstelle> optionalAnlaufstelle = anlaufstelleRepository.findById(aid);
       if(!optionalAnlaufstelle.isPresent()) {
          LOGGER.info("Anlaufstelle {} nicht gefunden.", aid);
          return ResponseEntity.notFound().build();
       }
       anlaufstelle.setId(aid);
       return new ResponseEntity<>(anlaufstelleRepository.save(anlaufstelle), HttpStatus.ACCEPTED);
    }

    /**
     * DELETE Anlaufstelle
     * @param aid ID der Anlaufstelle
     * @return
     */
    @DeleteMapping("/{aid}")
    public ResponseEntity<?> deleteAnlaufstelle(@PathVariable("aid") long aid) {
        LOGGER.info("DELETE Anlaufstelle {}.", aid);
        anlaufstelleRepository.deleteById(aid);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * GET Mitarbeiter für eine Anlaufstelle
     * @param aid ID der Anlaufstelle
     * @return
     */
    @GetMapping("/{aid}/mitarbeiter")
    public ResponseEntity<?> getAnlaufstellenMitarbeiter(@PathVariable("aid") long aid) {
        final Iterable<Mitarbeiter> mitarbeiter = this.anlaufstelleRepository.findById(aid).get().getMitarbeiterListe();
        Resources<Mitarbeiter> mitarbeiterResource = new Resources<>(mitarbeiter);
        mitarbeiterResource.add(linkTo(methodOn(AnlaufstellenController.class).getAnlaufstellenMitarbeiter(aid)).withSelfRel());
        LOGGER.info("GET Mitarbeiter für Anlaufstelle {}.", aid);
        return ResponseEntity.ok(mitarbeiterResource);
    }

    /**
     * POST Mitarbeiter zur Anlaufstelle
     * @param aid ID der Anlaufstelle
     * @param mitarbeiter Mitarbeiter für die Anlaufstelle
     * @return
     */
    @PostMapping("/{aid}/mitarbeiter")
    public ResponseEntity<?> postAnlaufstellenMitarbeiter(@PathVariable("aid") long aid, @RequestBody Mitarbeiter mitarbeiter) {
       LOGGER.info("POST Mitarbeiter zur Anlaufstelle {}", aid);
       Optional<Anlaufstelle> optAnlaufstelle = anlaufstelleRepository.findById(aid);
       if(optAnlaufstelle.isPresent()) {
           Anlaufstelle anlaufstelle = optAnlaufstelle.get();
           anlaufstelle.addMitarbeiter(mitarbeiter);
           return new ResponseEntity<>(anlaufstelleRepository.save(anlaufstelle), HttpStatus.CREATED);
       }
       else {
           LOGGER.info("Anlaufstelle {} not found", aid);
           return ResponseEntity.notFound().build();
       }
    }


    @PutMapping("/{aid}/mitarbeiter/{mid}")
    public ResponseEntity<?> putAnlaufstellenMitarbeiter(@PathVariable("aid") long aid, @PathVariable("mid") long mid) {
        Optional<Anlaufstelle> optionalAnlaufstelle = anlaufstelleRepository.findById(aid);
        if(!optionalAnlaufstelle.isPresent()) {
            LOGGER.info("Anlaufstelle {} nicht gefunden.", aid);
            return ResponseEntity.notFound().build();
        }
        Anlaufstelle anlaufstelle = optionalAnlaufstelle.get();
        // TODO find Mitarbeiter by ID and "put it"
        return ResponseEntity.notFound().build();
    }

    /**
     * DELETE Mitarbeiter der Anlaufstelle
     * @param aid ID der Anlaufstelle
     * @param mid ID des Mitarbeiters
     * @return
     */
    @DeleteMapping("/{aid}/mitarbeiter/{mid}")
    public ResponseEntity<?> deleteAnlaufstelle(@PathVariable("aid") long aid, @PathVariable("mid}") long mid) {
        LOGGER.info("DELETE Mitarbeiter {} der Anlaufstelle {}.", mid, aid);
        Optional<Anlaufstelle> optAnlaufstelle =  anlaufstelleRepository.findById(aid);
        if(optAnlaufstelle.isPresent()) {
            Anlaufstelle anlaufstelle = optAnlaufstelle.get();
            anlaufstelle.removeMitarbeiter(mid);
            return new ResponseEntity<>(anlaufstelleRepository.save(anlaufstelle), HttpStatus.ACCEPTED);
        }
        else {
            LOGGER.info("Anlaufstelle {} not found", aid);
            return ResponseEntity.notFound().build();
        }
    }
}
