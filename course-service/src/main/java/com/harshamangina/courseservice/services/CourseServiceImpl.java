package com.harshamangina.courseservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshamangina.courseservice.entity.Course;
import com.harshamangina.courseservice.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCoursesByCourseInstructors(String courseInstructor) {
        return courseRepository.findBycourseInstructor(courseInstructor);
    }

    @Override
    public List<Course> getAllCoursesByCourseType(String courseType) {
        return courseRepository.findBycourseType(courseType);
    }
    
}
