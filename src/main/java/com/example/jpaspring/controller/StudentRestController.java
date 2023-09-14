package com.example.jpaspring.controller;

import com.example.jpaspring.model.Student;
import com.example.jpaspring.repository.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/")
    public String detteErRoden() {
        return "Du er i roden af JPAStudent";
    }

    @GetMapping("/students")
    public List<Student> students() {
        var obj = studentRepository.findAll();

        return obj;
    }

    @GetMapping("/studentsname/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @PostMapping("/poststudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    @PutMapping("/putstudent/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            student.setId(id);
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if(orgStudent.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }
}
