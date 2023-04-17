package com.mirea.attendancesystembackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "persons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    private Long uid;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50)
    private String jobTitle;

    @Column(nullable = false)
    private Character gender;

    @Column(length = 20)
    private String number;

    @JsonIgnore()
    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Attendance> attendances;

}