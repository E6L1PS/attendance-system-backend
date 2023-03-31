package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.service.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gate")
public class GateController {

    private final GateService gateService;

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
