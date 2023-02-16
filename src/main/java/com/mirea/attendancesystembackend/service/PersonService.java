package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }
}
