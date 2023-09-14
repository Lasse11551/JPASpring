package com.example.jpaspring.repository;

import com.example.jpaspring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
    //List<Student> findAllByID(int id);
}
