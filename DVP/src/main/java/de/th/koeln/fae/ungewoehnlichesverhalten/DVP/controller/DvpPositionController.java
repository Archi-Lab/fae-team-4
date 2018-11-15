package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.controller;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Position;
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

import java.util.Date;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
@RequestMapping("/dvps")
public class DvpPositionController {

    private final DvpRepository dvpRepository;

    @Autowired
    public DvpPositionController(
            DvpRepository dvpRepository) {
        this.dvpRepository = dvpRepository;
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

    @GetMapping("/{id}/filter")
    public ResponseEntity<?> getDVPFilter(@PathVariable("id") long id,
                                          @RequestParam("lat") long lat,
                                          @RequestParam("lon") long lon,
                                          @RequestParam("radius") long radius)
    {
        // http://localhost:8081/dvps/1/filter?lat=1&lon=2&radius=10

        final DVP dvp = new DVP(radius);

        dvp.AddAufenthaltsort(new Aufenthaltsort(new Date(), new Position(lat, lon)));

        Resource<DVP> resource = new Resource<>(dvp);

        // todo: Filtern

        resource.add(linkTo(methodOn(DvpPositionController.class).getDVPFilter(id, lat, lon, radius)).withSelfRel());

        return  ResponseEntity.ok(resource);
    }
}
