package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.dto.DateDTO;
import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/at")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/all")
    public List<Attendance> getAttendances() {
        return attendanceService.getAttendances();
    }

    @GetMapping("/{uid}")
    public List<Attendance> getAttendancesByUid(@PathVariable Long uid) {
        return attendanceService.getAttendancesByUid(uid);
    }

    @GetMapping("/times/{uid}")
    public List<LocalTime> getAttendanceTimeByUid(@PathVariable Long uid) {
        return attendanceService.getTime(uid);
    }

    @GetMapping("/perday/{uid}/{date}")
    public Duration getHoursWorkedPerDayByUid(@PathVariable Long uid, @PathVariable LocalDate date) {
        return attendanceService.countHoursForDate(uid, date);
    }

    @GetMapping("/dates/{uid}")
    public List<DateDTO> getAllByUid(@PathVariable Long uid) {
        return attendanceService.getAllByUid(uid);
    }


    //TODO количество посещений по айди
    @PostMapping("/add/{uid}/{gateName}")
    public void addAttendance(@PathVariable Long uid, @PathVariable String gateName) {
        attendanceService.addAttendance(uid, gateName);
    }

}
