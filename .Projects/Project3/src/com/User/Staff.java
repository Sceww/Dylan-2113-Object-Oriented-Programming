package com.User;

public class Staff extends User {
    String department;

    public Staff(int id, String username, String password, String name, String email, /**/ String department) {
        super(id, username, password, name, email);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String newDepartment) {
        department = newDepartment;
    }

    @Override
    public String toString() {
        return String.format("[%d - '%s', name=\"%s\", email=\"%s\", department=\"%s\"]", getId(), getUsername(), getName(), getEmail(), getDepartment());
    }
}
