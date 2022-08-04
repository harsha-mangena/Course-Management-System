package com.harshamangina.courseservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "COURSE")
@Data
@Builder
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_instructor", nullable = false)
    private String courseInstructor;

    @Column(name = "course_type", nullable = false)
    private String courseType;

}
