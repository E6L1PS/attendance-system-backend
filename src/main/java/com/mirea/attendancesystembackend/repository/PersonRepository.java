package com.mirea.attendancesystembackend.repository;


import com.mirea.attendancesystembackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByUid(Long uid);

}
