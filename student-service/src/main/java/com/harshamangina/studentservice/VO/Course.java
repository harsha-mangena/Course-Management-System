package com.harshamangina.studentservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private Integer courseId;

    private String courseName;

    private String courseInstructor;

    private String courseType;
    
}
