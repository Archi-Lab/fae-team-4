package de.th.koeln.unusualbehavior.models;


import de.th.koeln.unusualbehavior.repository.ContactPointRepository;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactPointTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(ContactPointTest.class);

    @Autowired
    private ContactPointRepository contactPointRepository;

    @Test
    public void createContactPointExpectedCreated(){

        ContactPoint contactPoint = new ContactPoint();
        contactPoint.setName("Penny");

        Position position = new Position();
        position.setCoordinates(50.192, 7.65);
        contactPoint.setPosition(position);

        Employer employer = new Employer();
        employer.setSurname("Peter");
        employer.setName("Müller");

        Employer employer2 = new Employer();
        employer2.setSurname("Max");
        employer2.setName("Mustermann");

        ArrayList<Employer> employerList = new ArrayList<>();
        employerList.add(employer);
        employerList.add(employer2);

        contactPoint.setEmployer(employerList);

        ContactPoint contactPointSaved = contactPointRepository.save(contactPoint);

        LOGGER.info("ContactPoint to save:");
        LOGGER.info(contactPoint.toString());

        assertNotNull(contactPointSaved);
        assertNotNull(contactPointSaved.getId());
        assertEquals(contactPoint.getName(), contactPointSaved.getName());
        assertEquals(position.getLatitude(), contactPointSaved.getPosition().getLatitude(), 0);
        assertEquals(position.getLongitude(), contactPointSaved.getPosition().getLongitude(), 0);
        assertThat(contactPoint.getEmployer(), IsIterableContainingInOrder.contains((employerList.toArray())));

        LOGGER.info("ContactPoint was saved:");
        LOGGER.info(contactPointSaved.toString());

        contactPointRepository.delete(contactPointSaved);

        LOGGER.info("ContactPoint deleted");
    }
}