package com.harshamangina.studentservice.VO;

import java.util.List;

import com.harshamangina.studentservice.entities.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateWithCourse {
    
    private Student student;
    private List<Course> coursesId;
    
}
