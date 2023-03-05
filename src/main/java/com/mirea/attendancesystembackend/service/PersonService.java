package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Transactional
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAll() {
        log.info(" called getAllPersons");
        return personRepository.findAll();
    }


    public Person getPerson(Long uid) {
        log.info(" called getPerson");
        return personRepository.findPersonByUid(uid);
    }

    public void deletePersonByUid(Long uid) {
        log.info(" called deletePerson");
        personRepository.deleteById(uid);
    }

    public void updatePerson(Person person) {

        log.info(" called updatePerson");
        personRepository.updatePeron(person.getUid(), person.getName(), person.getLastName(),person.getJobTitle(), person.getGender());
    }
}
