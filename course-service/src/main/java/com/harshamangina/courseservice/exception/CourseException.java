package com.harshamangina.courseservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseException {
    
    @ExceptionHandler(value = CourseNotFoundException.class)
    public ResponseEntity<Object> exception(CourseNotFoundException exception){
        return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND ); 
    }
}
