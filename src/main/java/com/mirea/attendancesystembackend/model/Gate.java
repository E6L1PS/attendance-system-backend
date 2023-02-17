package com.mirea.attendancesystembackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "gates")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonIgnore()
    @OneToMany(mappedBy = "gate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attendance> attendances;

    public Gate(String name) {
        this.name = name;
    }


}
