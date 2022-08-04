package com.harshamangina.courseservice.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.harshamangina.courseservice.CourseServiceApplication;
import com.harshamangina.courseservice.entity.Course;
import com.harshamangina.courseservice.repository.CourseRepository;

@TestInstance(Lifecycle.PER_CLASS)
@DataJpaTest
@ContextConfiguration(classes=CourseServiceApplication.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    Course course1, course2, course3;
    
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
    void testForAddingCourseIntoRepository(){
        assertNull(repository.findById(1));
    }
    
}
