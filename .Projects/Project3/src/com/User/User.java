package com.User;

public abstract class User implements Comparable<User> {
    int id;
    String username;
    String password;
    String name; 
    String email;

    public User(int id, String username, String password, String name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }   

    // IMMUTABLE
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    // getters / setters
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    abstract public String toString();
    
    @Override
    public int compareTo(User other) {
        return (this.id - other.id);
    }
}
