package com.harshamangina.studentservice.services;

import java.util.List;

import com.harshamangina.studentservice.entities.Student;

public interface StudentService {
    /**
     * Method : Save Student
    */
    public void addNewStudent(Student student);

    /**
     * Method: Fetch by StudentId
     */
    public Student getStudentByStudentId(Integer studentId);

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
     * Method : Adding new course to student
     */
    public void registerCourseToStudent(Integer studentId, Integer courseId);

    /**
     * Method : Removing student from course.
     */
    public void removeCourseFromStudent(Integer studentId, Integer courseId);

}
