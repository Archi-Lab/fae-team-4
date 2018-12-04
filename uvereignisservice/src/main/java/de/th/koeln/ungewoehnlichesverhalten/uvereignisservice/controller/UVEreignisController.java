package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class UVEreignisController {

    private final UVEreignisRepository uvEreignisRepository;

    @Autowired
    public UVEreignisController(UVEreignisRepository uvEreignisRepository) {
        this.uvEreignisRepository = uvEreignisRepository;
    }

    /**
     * GET auf alle UVEreignisse
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getUVEreignisse() {
        final Iterable<UVEreignis> uvEreignis = this.uvEreignisRepository.findAll();
        Resources<UVEreignis> resources = new Resources<>(uvEreignis);
        resources.add(linkTo(methodOn(UVEreignisController.class).getUVEreignisse()).withSelfRel());
        return ResponseEntity.ok(resources);
    }

    //TODO: POST uvereignisse

    /**
     * GET auf bestimmtes UVEreignis (by ID)
     * @param eid
     * @return
     */
    @GetMapping(path = "/uvereignisse/{eId}")
    public ResponseEntity<?> getUVEreignis (@PathVariable("eId") long eid) {
        final Optional<UVEreignis> uvEreignis = this.uvEreignisRepository.findById(eid);
        Resource<Optional<UVEreignis>> uvEreignisRessource = new Resource<>(uvEreignis);
        uvEreignisRessource.add(linkTo(methodOn(UVEreignisController.class).getUVEreignis(eid)).withSelfRel());
        return ResponseEntity.ok(uvEreignisRessource);
    }

    //TODO: PATCH/PUT /uvereignisse/{eId}
    //TODO: PUT /uvereignisse/{eId}/senden

    /**
     * DELETE auf bestimmtes UVEreignis (by ID)
     * @param eid
     */
    @DeleteMapping(path = "/uvereignisse/{eId}")
    public void deleteUVEreignis(@PathVariable("eId") long eid) {
        this.uvEreignisRepository.deleteById(eid);
    }

    /**
     * Post einer Sprachnachricht auf bestimmtes UVEreignis (by ID)
     */
    /*@PostMapping(path = "/uvereignisse/{eId}/sprachnachricht")
    public ResponseEntity<?> postSprachnachricht(@PathVariable("eId") Long id) {
        final Optional<UVEreignis> optionalUVEreignis = this.uvEreignisRepository.findById(id);
        if (optionalUVEreignis.isPresent()) {
            final UVEreignis uvEreignis = optionalUVEreignis.get();
            //final Sprachnachricht sprachnachricht = uvEreignis.getSprachnachricht();
            //Macht irgendwie keinen Sinn, weil durch das ändern des UVE die Sprachnachricht ja automatisch geändert wird
            try {
                uvEreignis.setSprachnachricht(sprachnachricht); //zuerst get und hier setze ich sie dann wieder?
                this.uvEreignisRepository.save(uvEreignis);
                return ResponseEntity.ok(new Resource<>(uvEreignis));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    /**
     * Post einer Danke-Nachricht auf bestimmtes UVEreignis (by ID)
     */
    /*@PostMapping(path = "/uvereignisse/{eId}/danke")
    public ResponseEntity<?> postDankenachricht(@PathVariable("eId") Long id) {
        final Optional<UVEreignis> optionalUVEreignis = this.uvEreignisRepository.findById(id);
        if (optionalUVEreignis.isPresent()) {
            final UVEreignis uvEreignis = optionalUVEreignis.get();
            //final Dankenachricht dankenachricht = uvEreignis.getDankenachricht();
            //Macht irgendwie keinen Sinn, weil durch das ändern des UVE die Dankenachricht ja automatisch geändert wird
            try {
                uvEreignis.setDankenachricht(dankenachricht); //zuerst get und hier setze ich sie dann wieder?
                this.uvEreignisRepository.save(uvEreignis);
                return ResponseEntity.ok(new Resource<>(uvEreignis));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    //TODO: GET /uvereignisse/{eId}/danke/{dId}
    //TODO: GET /uvereignisse/{eId}/danke

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