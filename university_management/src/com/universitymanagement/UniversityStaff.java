package com.universitymanagement;

interface Researcher {
    void conductResearch();
}

interface Mentor {
    void guideStudents();
}

class UniversityStaff {
    protected String name;
    protected String staffID;
    protected String department;

    public UniversityStaff(String name, String staffID, String department) {
        this.name = name;
        this.staffID = staffID;
        this.department = department;
    }
}

class Professor extends UniversityStaff implements Researcher, Mentor {
    private String specialization;

    public Professor(String name, String staffID, String department, String specialization) {
        super(name, staffID, department);
        this.specialization = specialization;
    }

    public void displayRole() {
        System.out.println("Professor: " + name + " specializes in " + specialization);
    }

    public void conductResearch() {
        System.out.println("Professor " + name + " is conducting research.");
    }

    public void guideStudents() {
        System.out.println("Professor " + name + " is mentoring students.");
    }
}

class AdminStaff extends UniversityStaff {
    private String role;

    public AdminStaff(String name, String staffID, String department, String role) {
        super(name, staffID, department);
        this.role = role;
    }

    public void displayRole() {
        System.out.println("Admin Staff: " + name + " works as " + role);
    }
}