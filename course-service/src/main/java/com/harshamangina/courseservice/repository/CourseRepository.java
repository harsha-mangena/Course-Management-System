package com.harshamangina.courseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshamangina.courseservice.entity.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
    /**
     * Method: To fetch courses by instructor.
     */
    public List<Course> findBycourseInstructor(String courseInstructor);

    /**
     * Method : to fetch courses by course types.
     */
    public List<Course> findBycourseType(String courseType);
}
