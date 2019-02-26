package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.controller;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.Status;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.services.DvpUvePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class UVEreignisController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UVEreignisController.class);
    private final UVEreignisRepository uvEreignisRepository;

    @Autowired
    private final DvpUvePublisher dvpUvePublisher;


    @Autowired
    public UVEreignisController(UVEreignisRepository uvEreignisRepository, DvpUvePublisher dvpUvePublisher){
        this.uvEreignisRepository = uvEreignisRepository;
        this.dvpUvePublisher = dvpUvePublisher;
    }

    @PutMapping("/uvereignisse/{id}/senden")
    ResponseEntity<?> setUVEreignisSenden(@PathVariable Long id) {

        final Optional<UVEreignis> optUVEreignis = this.uvEreignisRepository.findById(id);

        if(optUVEreignis.isPresent())
        {
            UVEreignis uvEreignis = optUVEreignis.get();

            if(uvEreignis.getStatus() == Status.ERSTELLT)
            {
                Resource<UVEreignis> resource = new Resource<>(uvEreignis);
                resource.add(linkTo(methodOn(UVEreignisController.class).setUVEreignisSenden(id)).withSelfRel());
                dvpUvePublisher.sendeUVEreignis(uvEreignis);
                return ResponseEntity.ok(resource);
            }
            LOGGER.info("UVEreignis wurde schon versendet.");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            LOGGER.info("UVEreignis<+"+ id+"> wurde nicht gefunden");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}