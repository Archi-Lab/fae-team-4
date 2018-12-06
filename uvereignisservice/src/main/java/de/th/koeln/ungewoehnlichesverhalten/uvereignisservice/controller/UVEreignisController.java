package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.Dankenachricht;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.Sprachnachricht;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class UVEreignisController {

    private final UVEreignisRepository uvEreignisRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UVEreignisController.class);

    @Autowired
    public UVEreignisController(UVEreignisRepository uvEreignisRepository) {
        this.uvEreignisRepository = uvEreignisRepository;
    }

    /**
     * GET auf alle UVEreignisse
     * @return
     */
    @GetMapping(path = "/uvereignisse")
    public ResponseEntity<?> getUVEreignisse() {
        final Iterable<UVEreignis> uvEreignisse = this.uvEreignisRepository.findAll();
        Resources<UVEreignis> resources = new Resources<>(uvEreignisse);
        resources.add(linkTo(methodOn(UVEreignisController.class).getUVEreignisse()).withSelfRel());
        return ResponseEntity.ok(resources);
    }

    /**
     * POST UVEreignisse
     * @param uvEreignis
     * @return
     */
    @PostMapping()
    public ResponseEntity<?> postUVEreignis(@RequestBody UVEreignis uvEreignis){
        LOGGER.info("POST UVEreignis");
        // hier setAnlaufstelle des UVEreignisses?
        return new ResponseEntity<>(uvEreignisRepository.save(uvEreignis), HttpStatus.CREATED);
    }

    /**
     * GET auf bestimmtes UVEreignis (by ID)
     * @param eid ID des UVEreignis
     * @return
     */
    @GetMapping(path = "/uvereignisse/{eId}")
    public ResponseEntity<?> getUVEreignis (@PathVariable("eId") long eid) {
        final Optional<UVEreignis> uvEreignis = this.uvEreignisRepository.findById(eid);
        Resource<Optional<UVEreignis>> uvEreignisRessource = new Resource<>(uvEreignis);
        uvEreignisRessource.add(linkTo(methodOn(UVEreignisController.class).getUVEreignis(eid)).withSelfRel());
        return ResponseEntity.ok(uvEreignisRessource);
    }

    /**
     * PUT UVEreignis by ID zum Updaten
     * @param eid ID des UVEreignis
     * @return
     */
    @PutMapping("/uvereignisse/{eid}")
    public ResponseEntity<?> putUVEreignis(@PathVariable("eid") long eid, @RequestBody UVEreignis uvEreignis) {
        Optional<UVEreignis> optionalUVEreignis = uvEreignisRepository.findById(eid);
        if(!optionalUVEreignis.isPresent()) {
            LOGGER.info("UVEreignis {} nicht gefunden.", eid);
            return ResponseEntity.notFound().build();
        }
        uvEreignis.setId(eid);
        return new ResponseEntity<>(uvEreignisRepository.save(uvEreignis), HttpStatus.ACCEPTED);
    }

    /**
     * PUT UVEreignis by ID zum Senden
     * @param eid ID des UVEreignis
     * @return
     */
    @PutMapping("/uvereignisse/{eid}/senden")
    public ResponseEntity<?> putUVEreignisSenden(@PathVariable("eid") long eid, @RequestBody UVEreignis uvEreignis) {
        Optional<UVEreignis> optionalUVEreignis = uvEreignisRepository.findById(eid);
        if(!optionalUVEreignis.isPresent()) {
            LOGGER.info("UVEreignis {} nicht gefunden.", eid);
            return ResponseEntity.notFound().build();
        }
        //setDVP (by Id) eigentlich
        return new ResponseEntity<>(uvEreignisRepository.save(uvEreignis), HttpStatus.ACCEPTED);
    }

    /**
     * DELETE auf bestimmtes UVEreignis (by ID)
     * @param eid ID des UVEreignis
     */
    @DeleteMapping(path = "/uvereignisse/{eId}")
    public ResponseEntity<?> deleteUVEreignis(@PathVariable("eId") long eid) {
        LOGGER.info("DELETE UVEreignis {}.", eid);
        this.uvEreignisRepository.deleteById(eid);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * Post einer Sprachnachricht auf bestimmtes UVEreignis (by ID)
     * @param eid ID des UVEreignis
     * @return
     */
    @PostMapping(path = "/uvereignisse/{eid}/sprachnachricht")
    public ResponseEntity<?> postSprachnachricht(@PathVariable("eid") long eid, @RequestBody Sprachnachricht sprachnachricht) {
        LOGGER.info("POST Sprachnachricht zum UVEreignis {}", eid);
        Optional<UVEreignis> optionalUVEreignis = this.uvEreignisRepository.findById(eid);
        if (optionalUVEreignis.isPresent()) {
            UVEreignis uvEreignis = optionalUVEreignis.get(); //nicht final?
            uvEreignis.setSprachnachricht(sprachnachricht); //oder add-Methode?
            return new ResponseEntity<>(uvEreignisRepository.save(uvEreignis), HttpStatus.CREATED);
        } else {
            LOGGER.info("UVEreignis {} not found", eid);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Post einer Danke-Nachricht auf bestimmtes UVEreignis (by ID)
     * @param eid ID des UVEreignis
     * @return
     */
    @PostMapping(path = "/uvereignisse/{eid}/sprachnachricht")
    public ResponseEntity<?> postDankenachricht(@PathVariable("eid") long eid, @RequestBody Dankenachricht dankenachricht) {
        LOGGER.info("POST Dankenachricht zum UVEreignis {}", eid);
        Optional<UVEreignis> optionalUVEreignis = this.uvEreignisRepository.findById(eid);
        if (optionalUVEreignis.isPresent()) {
            UVEreignis uvEreignis = optionalUVEreignis.get(); //nicht final?
            uvEreignis.setDankenachricht(dankenachricht); //oder add-Methode?
            return new ResponseEntity<>(uvEreignisRepository.save(uvEreignis), HttpStatus.CREATED);
        } else {
            LOGGER.info("UVEreignis {} not found", eid);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET Dankenachricht des UVE by id
     * @param eid ID des UVEreignis
     * @return
     */
    //Ein UVE hat doch nur eine DN?
    /*@GetMapping(path = "/uvereignisse/{eid}/danke")
    public ResponseEntity<?> getUVEreignisDankenachricht(@PathVariable("eid") long eid) {
        final Optional<Dankenachricht> dankenachricht = this.uvEreignisRepository.findById(eid).get().getDankenachricht();
        Resource<Optional<Dankenachricht>> dankenachrichtResource = new Resource<>(dankenachricht);
        dankenachrichtResource.add(linkTo(methodOn(UVEreignisController.class).getUVEreignisDankenachricht(eid)).withSelfRel());
        LOGGER.info("GET Mitarbeiter für Anlaufstelle {}.", eid);
        return ResponseEntity.ok(dankenachrichtResource);
    }*/ //Get Dankenachricht aus UVE

    // Brauchen wir das? Oder gibt es eh nur eine DN pro UVE?
    //TODO: GET /uvereignisse/{eId}/danke/{dId}

    @Bean
    public ResourceProcessor<Resource<UVEreignis>> UVEreignisProcessor() {

        return new ResourceProcessor<Resource<UVEreignis>>() {

            @Override
            public Resource<UVEreignis> process(Resource<UVEreignis> resource) {
                //TODO: Statusupdate
                return resource;
            }
        };
    }

}