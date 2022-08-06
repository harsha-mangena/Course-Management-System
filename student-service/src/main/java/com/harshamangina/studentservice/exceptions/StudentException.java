package com.harshamangina.studentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentException {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<Object> studentNotFoundException(StudentNotFoundException exception){
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StudentPassedEmptyException.class)
    public ResponseEntity<Object> studentPassedEmptyException(StudentPassedEmptyException exception){
        return new ResponseEntity<>("Please pass a valid object", HttpStatus.RESET_CONTENT);
    }

    @ExceptionHandler(value = CourseNotFoundException.class)
    public ResponseEntity<Object> CourseNotFoundException(CourseNotFoundException exception){
        return new ResponseEntity<>("Course Not Found to delete", HttpStatus.NOT_FOUND);
    }
}
