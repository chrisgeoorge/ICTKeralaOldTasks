package com.universitymanagement;

abstract class UniversityMember {
    protected String name;
    protected String id;

    public UniversityMember(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract void performRole();

    public void showDetails() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

class TeachingStaff extends UniversityMember {
    public TeachingStaff(String name, String id) {
        super(name, id);
    }
    public void performRole() {
        System.out.println("Teaching students.");
    }
}

class NonTeachingStaff extends UniversityMember {
    public NonTeachingStaff(String name, String id) {
        super(name, id);
    }
    public void performRole() {
        System.out.println("Managing university operations.");
    }
}