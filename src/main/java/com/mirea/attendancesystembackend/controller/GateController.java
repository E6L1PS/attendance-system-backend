package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.model.Gate;
import com.mirea.attendancesystembackend.service.GateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1/gate")
    public class GateController {

        private final GateService gateService;

        @GetMapping
        public List<Gate> getGates() {
            return gateService.getAll(Sort.by("name"));
        }

        @PostMapping("/{name}")
        public void createGate(@PathVariable String name) {
            gateService.addGate(name);
        }

        @DeleteMapping("/{name}")
        public void deleteGate(@PathVariable String name) {
            gateService.deleteGate(name);
        }

    }
