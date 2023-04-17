package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.dto.DateDTO;
import com.mirea.attendancesystembackend.model.Attendance;
import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.model.Person;
import com.mirea.attendancesystembackend.repository.AttendanceRepository;
import com.mirea.attendancesystembackend.repository.GateRepository;
import com.mirea.attendancesystembackend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    private final PersonRepository personRepository;

    private final GateRepository gateRepository;

    @Transactional(readOnly = true)
    public List<Attendance> getAttendances() {
        return attendanceRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
    }

    @Transactional(readOnly = true)
    public List<Attendance> getAttendancesByUid(Long uid) {
        return attendanceRepository.findAllByPerson_uid(uid, Sort.by(Sort.Direction.DESC, "date"));
    }

    public void addAttendance(Long uid, String name) {
        Person person = personRepository.findPersonByUid(uid);
        Gate gate = gateRepository.findGateByName(name);
        Boolean status = attendanceRepository.getLastStatus(person);
        Attendance attendance = Attendance.builder().person(person).gate(gate).status(status == null || !status).build();
        attendanceRepository.save(attendance);
    }


    @Transactional(readOnly = true)
    public List<DateDTO> getAllIntervalsByUid(Long uid) {
        Person person = personRepository.findPersonByUid(uid);
        List<Date> dates = attendanceRepository.getDates(person);

        List<DateDTO> dateDTOS = new ArrayList<>();
        dates.forEach(date ->
                dateDTOS.add(
                        new DateDTO(date,
                                attendanceRepository.findIntervalsBetweenStatusByPersonAndDate(person, date.toString())
                                        .stream()
                                        .map(interval -> {
                                            double seconds = interval.getSeconds();
                                            int minutes = interval.getMinutes();
                                            int hours = interval.getHours();
                                            return LocalTime.of(hours, minutes, Double.valueOf(seconds).intValue());
                                        })
                                        .collect(Collectors.toList()))));
        return dateDTOS;
    }

    public void deleteAll() {
        attendanceRepository.deleteAll();
    }

}
