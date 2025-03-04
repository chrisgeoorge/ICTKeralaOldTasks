package com.universitymanagement;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student student1 = new Student("Alice", "S101", 20);
        student1.displayInfo();
        ReportGenerator.saveToFile("students.txt", student1.getName() + ", " + student1.getStudentID());

        Professor prof = new Professor("Dr. Smith", "P202", "CS", "AI");
        prof.displayRole();
        prof.conductResearch();
        prof.guideStudents();
        ReportGenerator.saveToFile("staff.txt", prof.name + " - Professor");

        AdminStaff admin = new AdminStaff("Bob", "A303", "HR", "Manager");
        admin.displayRole();
        ReportGenerator.saveToFile("staff.txt", admin.name + " - AdminStaff");

        Course course = new Course("Data Structures");
        course.enrollStudent("Alice", "S101");
        ReportGenerator.saveToFile("courses.txt", "Data Structures - Alice (S101)");

        ReportGenerator.readFromFile("students.txt");
        ReportGenerator.readFromFile("staff.txt");
        ReportGenerator.readFromFile("courses.txt");
    }
}
