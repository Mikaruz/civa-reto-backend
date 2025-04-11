package com.civa.spring.app.controller;

import com.civa.spring.app.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seed")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @GetMapping()
    public String runSeed() {
        return seedService.seedDatabase();
    }
}
