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

}
