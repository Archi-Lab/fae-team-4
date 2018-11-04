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
        contactPoint.setCityName("Köln");
        contactPoint.setZipCode(new ZipCode("51061"));
        contactPoint.setAddress(new Address("Hohe Straße",  "13"));

        Employee employee = new Employee();
        employee.setSurname("Peter");
        employee.setName("Müller");

        Employee employee2 = new Employee();
        employee2.setSurname("Max");
        employee2.setName("Mustermann");

        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);

        contactPoint.setEmployee(employeeList);

        ContactPoint contactPointSaved = contactPointRepository.save(contactPoint);

        LOGGER.info("ContactPoint to save:");
        LOGGER.info(contactPoint.toString());

        assertNotNull(contactPointSaved);
        assertNotNull(contactPointSaved.getId());
        assertEquals(contactPoint.getName(), contactPointSaved.getName());
        assertEquals(position.getLatitude(), contactPointSaved.getPosition().getLatitude(), 0);
        assertEquals(position.getLongitude(), contactPointSaved.getPosition().getLongitude(), 0);
        assertEquals(contactPoint.getAddress().getStreet(), contactPointSaved.getAddress().getStreet());
        assertEquals(contactPoint.getCityName(), contactPointSaved.getCityName());
        assertThat(contactPoint.getEmployee(), IsIterableContainingInOrder.contains((employeeList.toArray())));

        LOGGER.info("ContactPoint was saved:");
        LOGGER.info(contactPointSaved.toString());

        contactPointRepository.delete(contactPointSaved);

        LOGGER.info("ContactPoint deleted");
    }
}
