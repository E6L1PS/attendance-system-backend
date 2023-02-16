package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/at")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/all")
    public List<Attendance> getAttendance() {
        return attendanceService.getAttendance();
    }

    @PostMapping("/add/{uid}")
    public void addAttendance(@PathVariable Long uid) {
        attendanceService.addAttendance(uid);
    }

}
