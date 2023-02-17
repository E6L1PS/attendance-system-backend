package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GateService {

    @Autowired
    private GateRepository gateRepository;

    public void addGate(String name) {
        gateRepository.save(new Gate(name));
    }

    public void deleteGate(String name) {
        gateRepository.deleteByName(name);
    }

    @Transactional(readOnly = true)
    public List<Gate> getAll(Sort sort) {
        return gateRepository.findAll(sort);
    }

}
