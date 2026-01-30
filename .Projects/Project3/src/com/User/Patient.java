package com.User;

import java.util.Scanner;

public class Patient extends User {
    String notes;

    public Patient(int id, String username, String password, String name, String email, /**/ String notes) {
        super(id, username, password, name, email);
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String newNotes) {
        notes = newNotes;
    }
    
    /**
     * Takes a String object and reads a patient's attributes from a CSV into a new Patient object. 
     * @param scnr
     * @return
     */
    public static Patient readUserAttributes(String attributes) {
        Scanner scnr = new Scanner(attributes);
        scnr.useDelimiter(",");

        int id = scnr.nextInt();
        String username = scnr.next();
        String password = scnr.next();
        String name = scnr.next();
        String email = scnr.next();
        String notes = scnr.next();

        scnr.close();
        return new Patient(id, username, password, name, email, notes);
    }

    @Override
    public String toString() {
        return String.format("[%d - '%s', name=\"%s\", email=\"%s\", notes=\"%s\"]", getId(), getUsername(), getName(), getEmail(), getNotes());
    }
}
