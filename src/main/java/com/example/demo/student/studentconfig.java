package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentconfig {
    @Bean
    CommandLineRunner commandLineRunner(Studentrepository repository){
        return args -> {
            Student Thimal=new Student(
                    "Thimal",
                    "adeeshathimal@gmail.com",
                    LocalDate.of(2002, Month.MARCH,31)

            );
            Student Dinithi=new Student(
                    "Dinithi",
                    "dinithiepi@gmail.com",
                    LocalDate.of(2002, Month.OCTOBER,17)

            );
            repository.saveAll(List.of(Thimal,Dinithi));
        };
    }
}