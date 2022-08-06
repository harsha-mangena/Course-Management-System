package com.harshamangina.studentservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshamangina.studentservice.entities.Student;
import com.harshamangina.studentservice.exceptions.StudentNotFoundException;
import com.harshamangina.studentservice.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentByStudentId(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        Student updateStudent = studentRepository.findById(studentId).get();

        if( !isValidStudentId(updateStudent)){
            studentRepository.save(updateStudent);
            return updateStudent;
        }

        if(updateStudent.getStudentDepartment()!=null && ! updateStudent.getStudentDepartment().equals(student.getStudentDepartment())){
            updateStudent.setStudentDepartment(student.getStudentDepartment());
        }

        if(updateStudent.getStudentEmail()!=null && ! updateStudent.getStudentEmail().equals(student.getStudentEmail())){
            updateStudent.setStudentEmail(student.getStudentEmail());
        }

        if(updateStudent.getStudentName()!=null && ! updateStudent.getStudentName().equals(student.getStudentName())){
            updateStudent.setStudentName(student.getStudentName());
        }

        if(updateStudent.getStudentEnrolledCourseIds()!=null && updateStudent.getStudentEnrolledCourseIds() != student.getStudentEnrolledCourseIds()){
            updateStudent.setStudentEnrolledCourseIds(student.getStudentEnrolledCourseIds());
        }

        studentRepository.save(updateStudent);
        return updateStudent;


    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId).get();

        if(isValidStudentId(student)){
            throw new StudentNotFoundException();
        }

        studentRepository.deleteById(studentId);
    }

    @Override
    public void registerCourseToStudent(Integer studentId, Integer courseId) {
        Student student = getStudentByStudentId(studentId);

        if(!isValidStudentId(student)){
            throw new StudentNotFoundException();
        }

        List<Integer> courseListId = student.getStudentEnrolledCourseIds();
        courseListId.add(courseId);
        student.setStudentEnrolledCourseIds(courseListId);
        studentRepository.save(student);
    }

    @Override
    public void removeCourseFromStudent(Integer studentId, Integer courseId) {
        Student student = getStudentByStudentId(studentId);

        if(!isValidStudentId(student)){
            throw new StudentNotFoundException();
        }

        List<Integer> courseListId = student.getStudentEnrolledCourseIds();
        courseListId.remove(courseId);
        student.setStudentEnrolledCourseIds(courseListId);
        studentRepository.save(student);      
    }

    private boolean isValidStudentId(Student student) {
        return student!=null ? true : false;
    }
    
}
