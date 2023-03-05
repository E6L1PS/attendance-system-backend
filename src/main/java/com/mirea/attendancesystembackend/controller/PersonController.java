package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public List<Person> getPersons() {
        return personService.getAll();
    }

    @GetMapping("/{uid}")
    public Person getPerson(@PathVariable Long uid) {
        return personService.getPerson(uid);
    }

    @PostMapping("/add")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PostMapping("/add/{name}")
    public void addPerson(@PathVariable String name) {
        personService.addPerson(new Person(name));
    }
    @PutMapping("/update")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }
    @DeleteMapping("/delete/{uid}")
    public void deletePerson(@PathVariable Long uid) {
        personService.deletePersonByUid(uid);
    }

}
