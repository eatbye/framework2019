package com.app.app.web;

import com.app.app.model.Person;
import com.app.app.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {
    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired private PersonService personService;

    @RequestMapping("list")
    public void list(){
        logger.debug("hello");
        logger.debug("personService = {}", personService);
        List<Person> personList = personService.personList();
        logger.debug("personList size = {}", personList.size());
        for(Person person : personList){
            logger.debug("person = {}", person);
        }
    }

    @RequestMapping("save")
    public void save(){
        logger.debug("person save ");
        Person person = new Person();
        person.setName("郝红梅");
        person.setIdCard("110108198701011231");
        person.setAddress("北京市朝阳区");
        person.setBirthday(new Date());

        personService.savePerson(person);

    }
}
