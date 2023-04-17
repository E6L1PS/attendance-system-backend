package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<Person> getPersons() {
        return personService.getAll();
    }

    @GetMapping("/{uid}")
    public Person getPerson(@PathVariable Long uid) {
        return personService.getPerson(uid);
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @PutMapping
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

    @DeleteMapping("/{uid}")
    public void deletePerson(@PathVariable Long uid) {
        personService.deletePersonByUid(uid);
    }

}
