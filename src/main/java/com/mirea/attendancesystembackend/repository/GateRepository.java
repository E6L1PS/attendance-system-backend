package com.mirea.attendancesystembackend.repository;

import com.mirea.attendancesystembackend.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GateRepository extends JpaRepository<Gate, Integer> {
    Gate findGateByName(String name);

    void deleteByName(String name);

}
