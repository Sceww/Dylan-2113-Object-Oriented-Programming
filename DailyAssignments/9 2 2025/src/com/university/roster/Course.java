package com.university.roster;

public class Course {

    // courseName
    String courseName;
    // students
    Student[] students;
    // studentCount
    int studentCount = 0;

    public Course(String courseName, int maxStudents) {
        // initialize attributes
        this.courseName = courseName;
        this.students = new Student[maxStudents];
    }

    public void addStudent(Student student) {
        // if course full
        if (studentCount >= students.length) {
            System.out.println("Course is full. Cannot add " + student.getName());
            return;
        }
        students[studentCount] = student;
        studentCount++;
    }

    public void printRoster() {
        System.out.println("Roster for: " + courseName);

        System.out.println("-------------------------");
        for (int idx = 0; idx < students.length; idx++) {
            students[idx].displayInfo();
        }
        System.out.println("-------------------------");
    }
}
