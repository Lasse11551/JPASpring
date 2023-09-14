package com.example.jpaspring.config;

import com.example.jpaspring.model.Student;
import com.example.jpaspring.repository.StudentRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        String name = "Bruce";
        String name2 = "Viktor";
        LocalDate ld = LocalDate.of(2010, 11, 12);
        LocalTime lt = LocalTime.of(10, 11, 12);

/*
            Student s1 = new Student();
            s1.setName(name);
            s1.setBornDate(ld);
            s1.setBornTime(lt);

            Student s2 = new Student();
            s2.setName("Viktor");
            s2.setBornDate(ld);
            s2.setBornTime(lt);

            studentRepository.save(s1);
            studentRepository.save(s2);

 */

    }
}
