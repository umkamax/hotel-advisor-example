package com.github.umkamax.hoteladvisor.ejb;

import com.github.umkamax.hoteladvisor.domain.AddressEntity;
import com.github.umkamax.hoteladvisor.domain.PersonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class PersonServiceEJB {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceEJB.class);

    @PersistenceContext(unitName = "hoteladvisorPU")
    EntityManager entityManager;

    public List<PersonEntity> getPersons() {

        logger.info("Getting persons from H2...");
        Query query = entityManager.createQuery("select p from PersonEntity p");
        List<PersonEntity> persons = query.getResultList();
        for (PersonEntity personEntity: persons) {
            logger.info("{}", personEntity);
        }
        logger.info(persons.size() + " persons in H2...");

        return persons;
    }

    private List<PersonEntity> getPersonEntities() {
        List<PersonEntity> persons = new ArrayList<>();

        PersonEntity doe = new PersonEntity();
        doe.setFirstName("John");
        doe.setLastName("Doe");

        Set<AddressEntity> addresses = new HashSet<>();

        AddressEntity address = new AddressEntity();
        address.setZipcode("11111");
        address.setCity("Doe-City");
        address.setStreet("Doe-Street");
        address.setBuilding("Doe-Building");
        address.setBuilding("32");
        address.setAppartment("112A");
        addresses.add(address);
        doe.setAddressList(addresses);

        address = new AddressEntity();
        address.setCity("John-City");
        address.setStreet("John-Street");
        address.setBuilding("John-Building");
        addresses.add(address);
        doe.setAddressList(addresses);

        persons.add(doe);

        PersonEntity gump = new PersonEntity();
        gump.setFirstName("Forrest");
        gump.setLastName("Gump");

        addresses = new HashSet<>();

        address = new AddressEntity();
        address.setCity("Gump-City");
        address.setStreet("Gump-Street");
        address.setBuilding("Gump-Building");
        addresses.add(address);
        gump.setAddressList(addresses);

        persons.add(gump);

        return persons;
    }
}
