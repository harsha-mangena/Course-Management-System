package com.harshamangina.studentservice.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.harshamangina.studentservice.VO.Course;
import com.harshamangina.studentservice.VO.ResponseTemplateWithCourse;
import com.harshamangina.studentservice.entities.Student;
import com.harshamangina.studentservice.exceptions.CourseNotFoundException;
import com.harshamangina.studentservice.exceptions.StudentNotFoundException;
import com.harshamangina.studentservice.repositories.StudentRepository;
import com.harshamangina.studentservice.util.CourseList;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Autowired 
    private RestTemplate restTemplate; 

    protected List<Course> studentRegisteredCourses = new ArrayList<>();

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }


    @Override
    public Student getStudentByStudentId(Integer studentId) {
        return  studentRepository.findById(studentId).get();
    }

    @Override
    public ResponseTemplateWithCourse getStudentAlongWithCourses(Integer studentId) {

        ResponseTemplateWithCourse response = new ResponseTemplateWithCourse();

        Student student = studentRepository.findById(studentId).get();

        if(!isValidStudentId(student)){
            throw new StudentNotFoundException();
        }

        List<Integer> courseId = student.getStudentEnrolledCourseIds();

        for(int i : courseId){
            Course course = restTemplate.getForObject("http://COURSE-SERVICE/v1/course/"+i, Course.class);
            studentRegisteredCourses.add(course);
        }

        response.setStudent(student);
        response.setCoursesId(studentRegisteredCourses);

        return response;

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Course> getAllAvailableCourses() {
        CourseList response = restTemplate.getForObject("http://COURSE-SERVICE/v1/course/all", CourseList.class );

        List<Course> availableCourseList = response.getCourses();

        return availableCourseList;
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        Student updateStudent = studentRepository.findById(studentId).get();

        if( !isValidStudentId(updateStudent)){
            studentRepository.save(updateStudent);
            return updateStudent;
        }

        if(updateStudent.getStudentDepartment()!=null && 
           student.getStudentDepartment()!= null &&
           !updateStudent.getStudentDepartment().equals(student.getStudentDepartment())){

            updateStudent.setStudentDepartment(student.getStudentDepartment());
        }

        if(updateStudent.getStudentEmail()!=null && 
           student.getStudentEmail()!=null &&
           !updateStudent.getStudentEmail().equals(student.getStudentEmail())){
            
            updateStudent.setStudentEmail(student.getStudentEmail());
        }

        if(updateStudent.getStudentName()!=null &&
           student.getStudentName()!=null &&
            !updateStudent.getStudentName().equals(student.getStudentName())){

            updateStudent.setStudentName(student.getStudentName());
        }

        if(updateStudent.getStudentEnrolledCourseIds()!=null &&
           student.getStudentEnrolledCourseIds()!=null 
           && updateStudent.getStudentEnrolledCourseIds() != student.getStudentEnrolledCourseIds()){

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
        
        if(!IsValidCourse(courseId, courseListId)){
            throw new CourseNotFoundException();
        }

        student.setStudentEnrolledCourseIds(courseListId);
        studentRepository.save(student);      
    }

    private boolean IsValidCourse(Integer courseId, List<Integer> courseList) {
        return courseList.contains(courseId);
    }

    private boolean isValidStudentId(Student student) {
        return student!=null ? true : false;
    }
    
}
