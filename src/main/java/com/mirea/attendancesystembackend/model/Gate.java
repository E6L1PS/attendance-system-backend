package com.mirea.attendancesystembackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "gates")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @JsonIgnore()
    @OneToMany(mappedBy = "gate", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Attendance> attendances;

}