package com.mirea.attendancesystembackend.repository;

import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.model.Person;
import org.postgresql.util.PGInterval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("select a.status from Attendance a where a.person = :person order by a.date desc limit 1")
    Boolean getLastStatus(@Param("person") Person person);

    List<Attendance> findAllByPerson_uid(Long uid);

    @Query("select a.date from Attendance a where a.person = :person order by a.date asc")
    List<LocalDateTime> getDatesByUid(@Param("person") Person person);

    @Query("SELECT AGE(t2.date, t1.date) " +
            "FROM Attendance t1 " +
            "JOIN Attendance t2 ON t1.id = t2.id - 1 " +
            "WHERE t1.person = :person " +
            "AND TO_CHAR(t1.date, 'yyyy-MM-dd') LIKE :date " +
            "AND t1.status = true " +
            "AND t2.status = false " +
            "ORDER BY t1.date")
    List<PGInterval> findDurationListByStatusAndPersonId(@Param("person") Person person, @Param("date") String date);//все интервалы PGInterval by person


    @Query("select a.date from Attendance a where a.person = :person AND TO_CHAR(a.date, 'yyyy-MM-dd') LIKE :date  order by a.date asc")
    List<LocalDateTime> countHoursForDate(@Param("person") Person person, @Param("date") String date);//все LocalDateTime по Date by person

    @Query("SELECT DISTINCT DATE(a.date) FROM Attendance a WHERE a.person = :person")
    List<Date> getDates(@Param("person") Person person);//все уникальные Date by person

}
