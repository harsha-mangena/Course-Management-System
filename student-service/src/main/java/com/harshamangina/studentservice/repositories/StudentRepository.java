package com.harshamangina.studentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshamangina.studentservice.entities.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
    
}
