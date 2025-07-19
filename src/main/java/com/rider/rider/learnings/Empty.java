package com.rider.rider.learnings;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Empty {
    @GetMapping("/")
    public String getName() {
        return "Ganesh here";
    }
 }
