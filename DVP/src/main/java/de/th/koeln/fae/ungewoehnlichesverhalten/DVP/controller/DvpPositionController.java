package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.controller;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Position;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.CustomDvpRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
@RequestMapping("/dvps")
public class DvpPositionController {

    private final DvpRepository dvpRepository;
    private final CustomDvpRepository customDvpRepository;
    private long erdradius = 6371;

    @Autowired
    public DvpPositionController( DvpRepository dvpRepository, CustomDvpRepository customDvpRepository) {
        this.dvpRepository = dvpRepository;
        this.customDvpRepository = customDvpRepository;
    }

    @GetMapping()
    public ResponseEntity<?> getDVPs(){
        final Iterable<DVP> personList = this.dvpRepository.findAll();

        Resources<DVP> resources = new Resources<>(personList);

        resources.add(linkTo(methodOn(DvpPositionController.class).getDVPs()).withSelfRel());

        return  ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDVP(@PathVariable("id") long id)
    {
        final DVP dvp = this.dvpRepository.findById(id);

        Resource<DVP> resource = new Resource<>(dvp);

        resource.add(linkTo(methodOn(DvpPositionController.class).getDVP(id)).withSelfRel());

        return  ResponseEntity.ok(resource);
    }

    @GetMapping("filter")
    public ResponseEntity<?> getDVPFilter(@RequestParam("lat") long lat,
                                          @RequestParam("lon") long lon,
                                          @RequestParam("radius") long radius)
    {
        // Beispiel: http://localhost:8081/dvps?lat=1&lon=2&radius=10
        final Iterable<DVP> dvps= customDvpRepository.findAllByUmkreissuche(lat, lon, radius);

        Resources<DVP> resources = new Resources<>(dvps);
        resources.add(linkTo(methodOn(DvpPositionController.class).getDVPFilter(lat, lon, radius)).withSelfRel());

        return ResponseEntity.ok(resources);
    }


}
