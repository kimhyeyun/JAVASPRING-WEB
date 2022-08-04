package com.example.studybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudyBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyBookApplication.class, args);
    }

}
