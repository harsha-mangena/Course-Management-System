package com.harshamangina.courseservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshamangina.courseservice.entity.Course;
import com.harshamangina.courseservice.services.CourseService;

@RestController
@RequestMapping("/v1/course")
public class CourseController {
    
    @Autowired
    CourseService courseServcie;
    /**
     * API : /add
     * Request Type : Post
    */
    @PostMapping("/add")
    public void addNewCOurse(@RequestBody Course newCourse){
        courseServcie.addNewCourse(newCourse);
    }

    /**
     * API :/course/{courseId}
     * Request Type : GET
     */
    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int id){
        return courseServcie.getCourseByCourseId(id);
    }

    /*
     * API : courses/all
     * Request Type : GET
     */
    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseServcie.getAllCourses();
    }

    /**
     * API : /instructor/all
     * Request Type : GET
     */
    @GetMapping("instructor/all/{courseInstructor}")
    public List<Course> getCourseListByInstructor(@PathVariable String courseInstructor){
        return courseServcie.getAllCoursesByCourseInstructors(courseInstructor);
    }

    /**
     * API : /type/all
     * Request Type : GET
     */
    @GetMapping("type/all/{courseType}")
    public List<Course> getAllCoursesByCourseType(@PathVariable String courseType){
        return courseServcie.getAllCoursesByCourseType(courseType);
    }
}
