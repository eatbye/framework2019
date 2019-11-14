package com.app.app.service;

import com.app.app.model.Person;
import com.app.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired private PersonRepository personRepository;

    public List<Person> personList(){
        return personRepository.findAll();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
