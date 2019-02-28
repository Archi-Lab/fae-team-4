package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.controller;


import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.CustomDvpRepository;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories.DvpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
@RequestMapping("/dvps")
public class DvpPositionController {

    private final DvpRepository mDVPRepo;

    @Autowired
    CustomDvpRepository mCustomDVPRepo;

    @Autowired
    public DvpPositionController( DvpRepository dvpRepository) {
        mDVPRepo = dvpRepository;
    }


    /**
     * Custom GET Mapping für Filterparameter der DVPs
     * Gibt alle DVPs zurück, die sich in einem gewissen radius um die Koordinaten (lon, lat) befinden
     * Werden die Suchparameter nicht angegeben, gibt die GET Methode alle DVPs zurück.
     *
     * Beispiel: http://localhost:8081/dvps?lat=1{@literal &}lon=2{@literal &}radius=10
     *
     * @param lat Latitude des Punktes
     * @param lon Longitude des Punktes
     * @param radius Suchradius um den Punkt
     * @return
     */
    @GetMapping()
    public ResponseEntity<?> getDVPs(@RequestParam(name = "latitude", required = false, defaultValue = "0") double lat,
                                          @RequestParam(name = "longitude", required = false, defaultValue = "0") double lon,
                                          @RequestParam(name = "radius", required = false, defaultValue = "0") int radius)
    {
        Iterable<DVP> dvps;

        if(lat > 0 && lon > 0 && radius > 0) {
            dvps = mCustomDVPRepo.findAllByUmkreissuche(lat, lon, radius);
        }else {
            dvps = mDVPRepo.findAll();

        }

        Resources<DVP> resources = new Resources<>(dvps);
        resources.add(linkTo(methodOn(DvpPositionController.class).getDVPs(lat, lon, radius)).withSelfRel());

        return ResponseEntity.ok(resources);
    }


}
