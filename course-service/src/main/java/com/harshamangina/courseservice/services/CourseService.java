package com.harshamangina.courseservice.services;

import java.util.List;

import com.harshamangina.courseservice.entity.Course;

public interface CourseService {
    
    /**
     * Method : Add new Course
     * @param: Course
     * @return : void 
     */
    public void addNewCourse(Course course);

    /**
     * Method : Get Course By Id
     * @param: Int Course Id
     * @return : Course
     */
    public Course getCourseByCourseId(int courseId);

    /**
     * Method : Get All Courses
     * @param : None
     * @return : List of Courses
     */
    public List<Course> getAllCourses();

    /**
     * Method : Get All Courses By Instructors
     * @param : String courseInstructor
     * @return : List of Courses
     */
    public List<Course> getAllCoursesByCourseInstructors(String courseInstructor);

    /**
     * Method : Get All Courses By Type
     * @param : String courseType
     * @return : List of Courses
     */
    public List<Course> getAllCoursesByCourseType(String courseType);
}
