package com.mirea.attendancesystembackend.repository;

import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("select a.status from Attendance a where a.person = :person order by a.date desc limit 1")
    Boolean getLastStatus(@Param("person") Person person);

    List<Attendance> findAllByPerson_uid(Long uid);

    @Query("select a.date from Attendance a where a.person = :person order by a.date asc")
    List<LocalDateTime> getDatesByUid(@Param("person") Person person);
}
