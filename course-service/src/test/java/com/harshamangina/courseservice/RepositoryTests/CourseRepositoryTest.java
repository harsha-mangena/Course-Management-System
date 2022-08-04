package com.harshamangina.courseservice.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
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
    
    @BeforeAll
    void SetUp(){
        Course course1 = Course.builder()
                        .courseId(1)
                        .courseInstructor("Udemy")
                        .courseName("How to take Photos")
                        .courseType("Art")
                        .build();

        Course course2 = Course.builder()
                        .courseId(34)
                        .courseName("Art of writing")
                        .courseInstructor("Pydi Talli")
                        .courseType("Art")
                        .build();

        Course course3 = Course.builder()
                        .courseId(342)
                        .courseName("ML with python")
                        .courseInstructor("Stats Dudes")
                        .courseType("Programming")
                        .build();

        repository.save(course1);
        repository.save(course2);
        repository.save(course3);
    }

    @Test
    void testForFetchingCourseFromRepository(){
        assertNotNull(repository.findById(1).get());
    }

    @Test
    void testForAddingCourseToRepository(){
        Course course4 = Course.builder()
                               .courseId(1235)
                               .courseName("Spring Boot")
                               .courseInstructor("Java Brains")
                               .courseType("Deveelopment")
                               .build();
                            
        repository.save(course4);

        assertNotNull(repository.findById(4));
    }

    @Test
    void testForGettingAllCourses(){
        assertEquals(3, repository.findAll().size());
    }
    
    @Test
    void testForGettingAllCoursesOfType(){
        assertEquals(1, repository.findBycourseType("Programming").size());
    }
}
