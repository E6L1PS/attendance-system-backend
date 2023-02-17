package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gate")
public class GateController {

    @Autowired
    private GateService gateService;

    @PostMapping("/new/{name}")
    public void createGate(@PathVariable String name) {
        gateService.addGate(name);
    }

    @GetMapping("/get")
    public List<Gate> getGates() {
        return gateService.getAll(Sort.by("name"));
    }

    @DeleteMapping("/delete/{name}")
    public void deleteGate(@PathVariable String name) {
        gateService.deleteGate(name);
    }

}
