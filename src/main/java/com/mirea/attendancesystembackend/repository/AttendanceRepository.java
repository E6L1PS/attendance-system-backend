package com.mirea.attendancesystembackend.repository;

import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.model.Person;
import org.postgresql.util.PGInterval;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("select a.status from Attendance a where a.person = :person order by a.date desc limit 1")
    Boolean getLastStatus(@Param("person") Person person);//последний статус сотрудника (вошел/вышел)

    List<Attendance> findAllByPerson_uid(Long uid, Sort sort);

    @Query("SELECT DISTINCT DATE(a.date) FROM Attendance a WHERE a.person = :person")
    List<Date> getDates(@Param("person") Person person);//все уникальные даты посещений сотрудника

    @Query("SELECT AGE(t2.date, t1.date) " +
            "FROM Attendance t1 " +
            "JOIN Attendance t2 ON t2.person = t1.person AND t1.date < t2.date " +
            "WHERE t1.person = :person " +
            "AND TO_CHAR(t1.date, 'yyyy-MM-dd') LIKE :date " +
            "AND t1.status = true " +
            "AND t2.status = false " +
            "AND t1.date =(SELECT MAX(t3.date) FROM Attendance t3 WHERE t3.person = t1.person AND t3.date < t2.date AND t3.status = true) " +
            "ORDER BY t1.date")
    List<PGInterval> findIntervalsBetweenStatusByPersonAndDate(@Param("person") Person person, @Param("date") String date);
    //все интервалы PGInterval

}
