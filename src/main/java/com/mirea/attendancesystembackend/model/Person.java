package com.mirea.attendancesystembackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    private Long uid;

    private String name;

    private String lastName;

    private String jobTitle;

    private Character gender;

    @JsonIgnore()
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendances;

    public Person(String name) {
        this.name = name;
    }
}
