package com.university.roster;

public class University {
    public static void main(String[] args) {
        // Create Student objects
        Student s101 = new Student("s101", "Alice Johnson", 3.8); 
        Student s102 = new Student("s102", "Bob Williams", 3.5);

        // Create Course object
        Course OOPCourse = new Course("Object-Oriented Programming", 1);

        // Add Students to Course
        OOPCourse.addStudent(s101);
        OOPCourse.addStudent(s102);

        // Print Roster
        OOPCourse.printRoster();
    }
}