package com.harshamangina.courseservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/Home")
    public String home(){
        return "<center><b>This is Course Service</b></center>";
    }
    
}
