package com.mirea.attendancesystembackend.repository;


import com.mirea.attendancesystembackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findPersonByUid(Long uid);

    @Modifying
    @Query("update Person p set p.name = :name, p.lastName = :lastname, p.jobTitle = :jobtitle, p.gender = :gender where p.uid = :uid")
    void updatePeron(@Param("uid") Long uid,
                     @Param("name") String name,
                     @Param("lastname") String lastName,
                     @Param("jobtitle") String jobTitle,
                     @Param("gender") Character gender);

}
