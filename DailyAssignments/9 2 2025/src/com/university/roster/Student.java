package com.university.roster;

public class Student {
    // studentId
    String studentID;
    // name
    String name;
    // gpa
    double gpa;

    public Student(String studentId, String name, double gpa) {
        // initialize attributes
        this.studentID = studentId;
        this.name = name;
        this.gpa = gpa;
    }

    public void displayInfo() {
        // Print -> ID: <studentId>, Name: <name>, GPA: <gpa>
        System.out.printf("ID: %s, Name: %s, GPA: %s\n", studentID, name, gpa);
    }

    public String getName() {
        // name
        return name;
    }
}
