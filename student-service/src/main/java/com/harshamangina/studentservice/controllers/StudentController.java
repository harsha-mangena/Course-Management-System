package com.harshamangina.studentservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshamangina.studentservice.entities.Student;
import com.harshamangina.studentservice.exceptions.StudentNotFoundException;
import com.harshamangina.studentservice.exceptions.StudentPassedEmptyException;
import com.harshamangina.studentservice.services.StudentService;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    /**
     * API : /add
     * Request : Post
     */
    @PostMapping("/add")
    public void addNewStudent(@RequestBody Student student){
        if(student == null){
            throw new StudentPassedEmptyException();
        }

        studentService.addNewStudent(student);
    } 

    /**
     * API : /{studentId}
     * Request : Get
     */
    @GetMapping("/{studentId}")
    public Student getSrudentById(@PathVariable Integer studentId){
        
        Student studentDto  = studentService.getStudentByStudentId(studentId);
        if(studentDto == null){
            throw new StudentNotFoundException();
        }

        return studentDto;
    }

    /**
     * API : /all
     * Request : Get
     */
    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

}
