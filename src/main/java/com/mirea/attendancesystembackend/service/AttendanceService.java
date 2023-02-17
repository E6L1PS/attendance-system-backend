package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.repository.AttendanceRepository;
import com.mirea.attendancesystembackend.repository.GateRepository;
import com.mirea.attendancesystembackend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private GateRepository gateRepository;

    @Transactional(readOnly = true)
    public List<Attendance> getAttendance() {
        return attendanceRepository.findAll();
    }

    public void addAttendance(Long uid, String name) {
        Person person = personRepository.findPersonByUid(uid);
        Gate gate = gateRepository.findGateByName(name);
        Boolean status = attendanceRepository.getLastStatus();
        attendanceRepository.save(new Attendance(person, gate, status != null ? !status : true));
    }

}
