package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.dto.DateDTO;
import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAttendances() {
        return attendanceService.getAttendances();
    }

    @GetMapping("/{uid}")
    public List<Attendance> getAttendancesByUid(@PathVariable Long uid) {
        return attendanceService.getAttendancesByUid(uid);
    }

    @GetMapping("/dates/{uid}")
    public List<DateDTO> getAllByUid(@PathVariable Long uid) {
        return attendanceService.getAllIntervalsByUid(uid);
    }

    @PostMapping("/{uid}/{gateName}")
    public void addAttendance(@PathVariable Long uid, @PathVariable String gateName) {
        attendanceService.addAttendance(uid, gateName);
    }

    @DeleteMapping
    public void deleteAllAttendances() {
        attendanceService.deleteAll();
    }

}