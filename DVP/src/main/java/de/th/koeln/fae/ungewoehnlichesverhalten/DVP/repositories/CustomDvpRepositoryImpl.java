package de.th.koeln.fae.ungewoehnlichesverhalten.DVP.repositories;

import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.Aufenthaltsort;
import de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.DVP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Implementierung der Custom-Funktionen für das Durchsuchen des DVP Repositories
 */
@Repository
@Transactional(readOnly = true)
public class CustomDvpRepositoryImpl implements CustomDvpRepository {

    private final EntityManager entityManager;

    @Autowired
    public CustomDvpRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    /**
     * Suchen einer DVP im Umkreis eines definierten Punktes.
     *
     * @param lat {@link de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Latitude} des Punktes
     * @param lon {@link de.th.koeln.fae.ungewoehnlichesverhalten.DVP.models.geo.Longitude} des Punktes
     * @param radius um den Punkt
     * @return
     */
    @Override
    public Iterable<DVP> findAllByUmkreissuche(double lat, double lon, long radius) {

        final Query query = entityManager.createNativeQuery("SELECT DISTINCT DVP.DVP_ID, DVP.BILD_URL, DVP.TRACKER_ID FROM DVP_AUFENTHALTSORTE da  LEFT JOIN AUFENTHALTSORT as a ON DVP_DVP_ID LEFT JOIN DVP ON DVP.DVP_ID = da.DVP_DVP_ID WHERE ( acos(sin(a.Latitude * 0.0175) * sin( ?  * 0.0175) + cos(a.Latitude * 0.0175) * cos( ?  * 0.0175) * cos(( ?  * 0.0175) - (a.Longitude * 0.0175))) * 6371 <= ? ) AND a.ID = da.AUFENTHALTSORTE_ID", DVP.class);

        query.setParameter(1, lat);
        query.setParameter(2, lat);
        query.setParameter(3, lon);
        query.setParameter(4, radius);

        System.out.println(query.toString());


        return query.getResultList();
    }

    @Override
    public void saveNeuenDvpAufenthaltsort(Aufenthaltsort aufenthaltsort, String trackerId){
        // Todo speichern
    }
}
