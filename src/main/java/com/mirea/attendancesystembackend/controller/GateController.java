package com.mirea.attendancesystembackend.controller;

import com.mirea.attendancesystembackend.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gate")
public class GateController {

    @Autowired
    private GateService gateService;

    @PostMapping("/set/{name}")
    public void setGate(@PathVariable String name) {
        gateService.setGateName(name);
    }

}
