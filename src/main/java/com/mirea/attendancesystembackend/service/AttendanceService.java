package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.repository.AttendanceRepository;
import com.mirea.attendancesystembackend.repository.GateRepository;
import com.mirea.attendancesystembackend.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
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
    public List<Attendance> getAttendances() {
        return attendanceRepository.findAll(Sort.by("date"));
    }

    @Transactional(readOnly = true)
    public List<Attendance> getAttendancesByUid(Long uid) {
        return attendanceRepository.findAllByPerson_uid(uid);
    }

    public void addAttendance(Long uid, String name) {
        Person person = personRepository.findPersonByUid(uid);
        Gate gate = gateRepository.findGateByName(name);
        Boolean status = attendanceRepository.getLastStatus(person);
        attendanceRepository.save(new Attendance(person, gate, status == null || !status));
    }

    @Transactional(readOnly = true)
    public List<Duration> getTime(Long uid) {
        Person person = personRepository.findPersonByUid(uid);
        List<LocalDateTime> localDateTimes = attendanceRepository.getDatesByUid(person);

        return IntStream
                .iterate(1, i -> i < localDateTimes.size(), i -> i + 2)
                .mapToObj(i -> Duration.between(localDateTimes.get(i), localDateTimes.get(i - 1)))
                .collect(Collectors.toList());
    }

}
