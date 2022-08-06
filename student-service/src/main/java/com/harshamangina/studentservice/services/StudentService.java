package com.harshamangina.studentservice.services;

import java.util.List;

import com.harshamangina.studentservice.VO.Course;
import com.harshamangina.studentservice.VO.ResponseTemplateWithCourse;
import com.harshamangina.studentservice.entities.Student;

public interface StudentService {
    /**
     * Method : Save Student
    */
    public void addNewStudent(Student student);

    /*
     * Method : Fetch by Student Id
    */
    public Student getStudentByStudentId(Integer studentId);

    /**
     * Method: Fetch by StudentId along with courses
     */
    public ResponseTemplateWithCourse getStudentAlongWithCourses(Integer studentId);

    /**
     * Method: Fetch All Students
     */
    public List<Student> getAllStudents();

    /**
     * Method : Update Student
     */
    public Student updateStudent(Integer studentId, Student student);

    /**
     * Method : Delete Student by Id
     */
    public void deleteStudent(Integer studentId);

    /**
     * Method : Get all courses
     * @param studentId
     * @param courseId
     */
    public List<Course> getAllAvailableCourses();

    /**
     * Method : Adding new course to student
     */
    public void registerCourseToStudent(Integer studentId, Integer courseId);

    /**
     * Method : Removing student from course.
     */
    public void removeCourseFromStudent(Integer studentId, Integer courseId);

}
