package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories;

import com.sun.xml.internal.rngom.digested.DValuePattern;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

@Repository
@Transactional(readOnly = true)
public class CustomDvpRepositoryImpl implements CustomDvpRepository {

    private final EntityManager entityManager;

    @Autowired
    public CustomDvpRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }


    public Iterable<DVP> findAllByUmkreissuche(double lat, double lng, long radius){

        final Query query = entityManager.createNativeQuery("SELECT d.* FROM DVP as d WHERE EXISTS (SELECT NULL FROM Aufenthaltsort as a WHERE a.DVP_id = d.id AND 6371 * (ACOS(SIN(RADIANS(d.Latitude)) * SIN(RADIANS(?1)) + COS(RADIANS(d.Latitude)) * COS(RADIANS(?1)) * COS(RADIANS(d.Longitude) - RADIANS(?2)))) < ?3 )", DVP.class);

        query.setParameter(1, lat);
        query.setParameter(2, lng);
        query.setParameter(3, radius);


        return query.getResultList();
    }

}
