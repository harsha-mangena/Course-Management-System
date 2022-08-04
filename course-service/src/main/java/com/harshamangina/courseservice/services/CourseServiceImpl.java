package com.harshamangina.courseservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshamangina.courseservice.entity.Course;
import com.harshamangina.courseservice.repository.CourseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void addNewCourse(Course course) {
        log.info("Inside Service : Adding course to repository");
        courseRepository.save(course);
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        log.info("Inside Service:  Fetching course by Id");
        return courseRepository.findById(courseId).get();
    }

    @Override
    public List<Course> getAllCourses() {
        log.info("Inside Service:  Fetching all courses");
        return courseRepository.findAll();
    }

    @Override
    @Deprecated
    public List<Course> getAllCoursesByCourseInstructors(String courseInstructor) {
        return courseRepository.findBycourseInstructor(courseInstructor);
    }

    @Override
    public List<Course> getAllCoursesByCourseType(String courseType) {
        log.info("Inside Service:  Fetching course by course type");
        return courseRepository.findBycourseType(courseType);
    }
    
}
