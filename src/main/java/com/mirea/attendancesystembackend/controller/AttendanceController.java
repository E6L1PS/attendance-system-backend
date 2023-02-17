package com.mirea.attendancesystembackend.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
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

    @GetMapping("/last/{uid}")
    public List<Duration> getLastAttendanceTime(@PathVariable Long uid) {
        return attendanceService.getTime(uid);
    }

    @PostMapping("/add/{uid}/{gateName}")
    public void addAttendance(@PathVariable Long uid, @PathVariable String gateName) {
        attendanceService.addAttendance(uid, gateName);
    }

}
