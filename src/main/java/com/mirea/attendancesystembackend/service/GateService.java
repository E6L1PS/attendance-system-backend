package com.mirea.attendancesystembackend.service;

import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.repository.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class GateService {

    @Autowired
    private GateRepository gateRepository;

    public void setGateName(String name) {
        gateRepository.save(new Gate(name));
    }
}
