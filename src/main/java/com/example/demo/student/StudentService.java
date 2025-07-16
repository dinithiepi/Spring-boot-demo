package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {

    private final Studentrepository studentrepository;

    @Autowired
    public StudentService(Studentrepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<Student> getStudents() {

        return studentrepository.findAll();

    }

}
