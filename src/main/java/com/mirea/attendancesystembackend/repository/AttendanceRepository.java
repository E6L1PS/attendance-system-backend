package com.mirea.attendancesystembackend.repository;

import com.mirea.attendancesystembackend.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("select a.status from Attendance a order by a.date desc limit 1")
    Boolean getLastStatus();
    Boolean findFirstStatusByOrderByIdDesc();
}
