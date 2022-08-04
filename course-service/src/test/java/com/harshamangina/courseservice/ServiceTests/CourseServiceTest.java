package com.harshamangina.courseservice.ServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.harshamangina.courseservice.entity.Course;
import com.harshamangina.courseservice.repository.CourseRepository;
import com.harshamangina.courseservice.services.CourseServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CourseServiceTest {

    @InjectMocks
    private CourseServiceImpl service;
    
    @MockBean
    CourseRepository repository;

    Course course1, course2, course3;
    
    @BeforeAll
    void setUp(){
        service = new CourseServiceImpl();
    }

    @BeforeEach
    void objectSetUp(){
        course1 = Course.builder()
                         .courseId(1)
                         .courseInstructor("Udemy")
                         .courseName("How to take Photos")
                         .courseType("Art")
                         .build();

        course2 = Course.builder()
                         .courseId(34)
                         .courseName("Art of writing")
                         .courseInstructor("Pydi Talli")
                         .courseType("Art")
                         .build();
        
        course3 = Course.builder()
                         .courseId(342)
                         .courseName("ML with python")
                         .courseInstructor("Stats Dudes")
                         .courseType("Programming")
                         .build();
    }

    @Test
    void testForCourseDetails(){

        assertEquals(1, course1.getCourseId());
        assertEquals("Udemy", course1.getCourseInstructor());
        assertEquals("How to take Photos", course1.getCourseName());
        assertEquals("Art", course1.getCourseType());

        assertEquals(34, course2.getCourseId());
        assertEquals("Pydi Talli", course2.getCourseInstructor());
        assertEquals("Art of writing", course2.getCourseName());
        assertEquals("Art", course2.getCourseType());

        assertEquals("Programming", course3.getCourseType());
        assertEquals("Stats Dudes", course3.getCourseInstructor());
        assertEquals("ML with python", course3.getCourseName());
        assertEquals(342, course3.getCourseId());
    }

    @Test
    void testForGettingAllCourses(){
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        when(repository.findAll()).thenReturn(courses);
        
        assertEquals(3, service.getAllCourses().size());
    }

    @Test
    void testForGettingCoursesByType(){
        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

        when(repository.findBycourseType("Art")).thenReturn(courses);

        assertEquals(2, service.getAllCoursesByCourseType("Art").size());
    }
}
