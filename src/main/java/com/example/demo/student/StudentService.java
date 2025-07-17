package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final Studentrepository studentrepository;

    @Autowired
    public StudentService(Studentrepository studentrepository) {
        this.studentrepository = studentrepository;
    }

    public List<Student> getStudents() {
        try {
            return studentrepository.findAll();
        } catch (Exception e) {
            System.err.println("Error fetching students: " + e.getMessage());
            throw new RuntimeException("Failed to fetch students", e);
        }
    }


    public Student addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentrepository.findStudentByEmail(student.getEmail());
        Optional<Object> studentOptional = Optional.empty();
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");

        }
        Student stu =  studentrepository.save(student);
        return stu;
    }
    public void deleteStudent(Long studentId) {
        boolean exists = studentrepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student not found");
        }
        studentrepository.deleteById(studentId);


    }

}
