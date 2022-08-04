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
import com.harshamangina.courseservice.exception.CourseNotFoundException;
import com.harshamangina.courseservice.services.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/course")
@Slf4j
public class CourseController {
    
    @Autowired
    CourseService courseServcie;
    /**
     * API : /add
     * Request Type : Post
    */
    @PostMapping("/add")
    public void addNewCOurse(@RequestBody Course newCourse){
        log.info("Inside Controller : Adding new Course");
        courseServcie.addNewCourse(newCourse);
    }

    /**
     * API :/course/{courseId}
     * Request Type : GET
     */
    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int id){
        log.info("Inside Controller : Fetching course by Id");
        Course courseDto = courseServcie.getCourseByCourseId(id);

        if(courseDto == null){
            throw new CourseNotFoundException();
        }

        return courseDto;
    }

    /*
     * API : courses/all
     * Request Type : GET
     */
    @GetMapping("/all")
    public List<Course> getAllCourses(){
        log.info("Inside Controller : Fetching all courses");
        return courseServcie.getAllCourses();
    }

    /**
     * API : /instructor/all
     * Request Type : GET
     */
    @Deprecated
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
        log.info("Inside Controller : Fetching course by course type");
        return courseServcie.getAllCoursesByCourseType(courseType);
    }
}
