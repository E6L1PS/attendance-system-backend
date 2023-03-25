package com.mirea.attendancesystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
public class DateDTO {

    private Date date;
    private List<LocalTime> dateTimeList;
}
