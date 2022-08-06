package com.harshamangina.studentservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Student getStudentById(@PathVariable Integer studentId){
        
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

    /**
     * API : /update/1
     * Request : PUT
     */
    @PutMapping("/update/{studentId}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer studentId){
        return studentService.updateStudent(studentId, student);
    }

    /**
     * API : /delete/{studentId}
     * Request : DELETE
     */
    @DeleteMapping("/delete/{studentId}")
    public void deleteStudent(Integer studentId){
        studentService.deleteStudent(studentId);
    }

    /**
     * API : /{studentId}/register/{courseId}
     * Request : POST
     */
    @PostMapping("/{studentId}/register/{courseId}")
    public void registerCourseToStudent(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.registerCourseToStudent(studentId, courseId);
    }

    /**
     * API : /{studentId}/unregister/{courseId}
     * Request : POST
     */
    @PostMapping("/{studentId}/unregister/{courseId}")
    public void unregisterCourseFromStudent(@PathVariable Integer studentId, @PathVariable Integer courseId){
        
    }

}
