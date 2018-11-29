package de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.models.UVEreignis;
import de.th.koeln.ungewoehnlichesverhalten.uvereignisservice.repositories.UVEreignisRepository;

@RepositoryRestController
public class UVEreignisController {

    private final UVEreignisRepository uvEreignisRepository;

    @Autowired
    public UVEreignisController(UVEreignisRepository uvEreignisRepository) {
        this.uvEreignisRepository = uvEreignisRepository;
    }

    @GetMapping(path = "/uvereignisse/{eId}")
    public Optional<UVEreignis> getUVEreignis(@PathVariable("eId") Long id) {
        return this.uvEreignisRepository.findById(id);
    }

    @PostMapping(path = "/uvereignisse/{eId}/sprachnachricht")
    public ResponseEntity<?> postSprachnachricht(@PathVariable("eId") Long id) {
        final Optional<UVEreignis> optionalUVEreignis = this.uvEreignisRepository.findById(id);
        if (optionalUVEreignis.isPresent()) {
            final UVEreignis uvEreignis = optionalUVEreignis.get();
            //final Sprachnachricht sprachnachricht = uvEreignis.getSprachnachricht();
            /*Macht irgendwie keinen Sinn, weil durch das ändern des UVE die Sprachnachricht ja automatisch geändert wird*/
            try {
                uvEreignis.setSprachnachricht(sprachnachricht); /*zuerst get und hier setze ich sie dann wieder?*/
                this.uvEreignisRepository.save(uvEreignis);
                return ResponseEntity.ok(new Resource<>(uvEreignis));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "/uvereignisse/{eId}/danke")
    public ResponseEntity<?> postDankenachricht(@PathVariable("eId") Long id) {
        final Optional<UVEreignis> optionalUVEreignis = this.uvEreignisRepository.findById(id);
        if (optionalUVEreignis.isPresent()) {
            final UVEreignis uvEreignis = optionalUVEreignis.get();
            //final Dankenachricht dankenachricht = uvEreignis.getDankenachricht();
            /*Macht irgendwie keinen Sinn, weil durch das ändern des UVE die Dankenachricht ja automatisch geändert wird*/
            try {
                uvEreignis.setDankenachricht(dankenachricht); /*zuerst get und hier setze ich sie dann wieder?*/
                this.uvEreignisRepository.save(uvEreignis);
                return ResponseEntity.ok(new Resource<>(uvEreignis));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/uvereignisse/{eId}")
    public void deleteUVEreignis(@PathVariable("eId") Long id) {
        this.uvEreignisRepository.deleteById(id);
    }

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