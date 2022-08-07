package com.harshamangina.apigateway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {


    @GetMapping("/courseServcieFallback")
    public String fallbackMethodForCourseService(){
        return "Course Service is taking longer than expected. Please try again." ;
    }

    @GetMapping("studentServiceFallback")
    public String fallbackMethodForStudentService(){
        return "Student Service is taking longer than expected. Please try again." ;   
    }
    
}
