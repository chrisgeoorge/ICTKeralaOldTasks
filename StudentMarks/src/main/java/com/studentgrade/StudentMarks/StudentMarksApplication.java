package com.studentgrade.StudentMarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMarksApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentMarksApplication.class, args);
		System.out.println("Student Grade Generator App is running at http://localhost:8080");
	}
}
