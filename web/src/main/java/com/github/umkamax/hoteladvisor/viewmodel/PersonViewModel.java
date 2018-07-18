package com.github.umkamax.hoteladvisor.viewmodel;

import com.github.umkamax.hoteladvisor.domain.PersonEntity;
import com.github.umkamax.hoteladvisor.ejb.PersonServiceEJB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Init;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.ArrayList;
import java.util.List;

public class PersonViewModel {

    Logger logger = LoggerFactory.getLogger(PersonViewModel.class);

    private static final String JNDI = "java:global/hotel-advisor-example/ejb/PersonServiceEJB" +
            "!com.github.umkamax.hoteladvisor.ejb.PersonServiceEJB";

    private Context context;
    private PersonServiceEJB personService;

    private PersonEntity selected;
    private List<PersonEntity> persons;

    @Init
    public void init() {
        logger.info("UI: initializing...");
    }

    @AfterCompose
    public void test() throws Exception {
        logger.info("UI: after compose...");
        context = new InitialContext();
        try {
            personService = (PersonServiceEJB) context.lookup(JNDI);
            persons = new ArrayList<>(personService.getPersons());
            selected = persons.get(0);
        } catch(Exception e) {
            logger.error("{}", e);
        }
    }

    public List<PersonEntity> getPersonList() {
        return persons;
    }

    public PersonEntity getSelectedPerson() {
        return selected;
    }
    public void setSelectedPerson(PersonEntity selectedPerson) {
        logger.info("Selected: " + selectedPerson);
        this.selected = selectedPerson;
    }


}
