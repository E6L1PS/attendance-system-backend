package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PostMapping("/add/{name}")
    public void addPerson(@PathVariable String name) {
        personService.addPerson(new Person(name));
    }

}