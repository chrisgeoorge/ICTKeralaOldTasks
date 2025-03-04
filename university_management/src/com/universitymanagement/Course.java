package com.universitymanagement;

import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private List<String> enrolledStudents = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void enrollStudent(String studentName) {
        enrolledStudents.add(studentName);
        System.out.println(studentName + " enrolled in " + courseName);
    }

    public void enrollStudent(String studentName, String studentID) {
        enrolledStudents.add(studentName + " (ID: " + studentID + ")");
        System.out.println(studentName + " (ID: " + studentID + ") enrolled in " + courseName);
    }
}

class OnlineCourse extends Course {
    public OnlineCourse(String courseName) {
        super(courseName);
    }
    public void conductClass() {
        System.out.println("Conducting an online class.");
    }
}

class OfflineCourse extends Course {
    public OfflineCourse(String courseName) {
        super(courseName);
    }
    public void conductClass() {
        System.out.println("Conducting an in-person class.");
    }
}
