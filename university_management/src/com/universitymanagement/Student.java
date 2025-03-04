package com.universitymanagement;

class Student {
    private String name;
    private String studentID;
    private int age;

    public Student(String name, String studentID, int age) {
        this.name = name;
        this.studentID = studentID;
        setAge(age);
    }

    public String getName() { return name; }
    public String getStudentID() { return studentID; }
    public int getAge() { return age; }

    public void setAge(int age) {
        if (age > 0) this.age = age;
        else throw new IllegalArgumentException("Age cannot be negative or zero.");
    }

    public void displayInfo() {
        System.out.println("Student: " + name + ", ID: " + studentID + ", Age: " + age);
    }
}