package com.System;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.User.*;

public class PatientManager {
    private User user;  // logged in user
    private boolean isStaff;
    private ArrayList<Patient> list = new ArrayList<>();
    
    private Patient selected; // currently selected patient
    
    public PatientManager(User user) {
        // based off of the type of user, perform different actions
        this.user = user;
        if (user instanceof Patient) {
            isStaff = false;
        } else if (user instanceof Staff) {
            isStaff = true;
            // fill in patient list
            try (Scanner fileScnr = new Scanner( new File("patient.csv") ) ) {
                fileScnr.useDelimiter(",");
                while (fileScnr.hasNextLine()) {
                    list.add(Patient.readUserAttributes(fileScnr.nextLine()));
                }
            } catch (IOException e) {
                System.out.println("Input Output exception! " + e.getMessage());
            }
            // sort list
            sortList();
        }
    }   
    
    private void sortList() {
        for (int i = 0; i < list.size()-1; i++) {
            int minIdx = i; // assuming the current position hold the smallest value...
            for (int k = i+1; k < list.size(); k++) { // starting from the next value till the end, 
                if (list.get(k).compareTo(list.get(minIdx)) < 0) { // is the next value less than minIdx?
                    minIdx = k; // if so, 'mark' this index as the lowest value of the unsorted portion.
                }
            }
            // swap
            Patient temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp); 
        }
    }
    /**
     * Searches the patient list 
     * @param list
     * @param id
     */
    public void selectPatient(int id) throws UserNotFoundException {
        int left = 0;
        int right = list.size()-1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid).getId() == id) {
                selected = list.get(mid);
                return;
            } else if (id < list.get(mid).getId()) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        throw new UserNotFoundException("Patient not found!");
    }
    
    /**
     * A static method to edit the attributes of a Patient/Staff object. The user must save and exit (modify the associated CSV file).
     * To save and exit, the entire CSV file is read, the associated entry line is modified, and then written to disk. 
     * @param user
     * @param scnr
     */
    public static void editUserAttributes(User user, Scanner scnr) {
        boolean runMenu = true; 
        String type = "???";
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String misc = "<NULL>";
        if (user instanceof Patient) {
            type = "Patient";
            misc = ((Patient)user).getNotes();
        } else if (user instanceof Staff) {
            type = "Staff";
            misc = ((Staff)user).getDepartment();
        }
        while (runMenu) {
            System.out.printf("""
            -- User Attribute Editor (%s, %s) --
            %s
            1. Edit name
            2. Edit email
            3. Edit password\n""", user.getUsername(), type, user);
            if (user instanceof Staff) {
                System.out.println("4. Edit department");
            } else {
                System.out.println("4. Edit notes");
            }
            System.out.print("0. Save and Exit\n> ");
            try {
                int choice = Integer.parseInt(scnr.nextLine());
                switch (choice) {
                    case 0:
                        runMenu = false;
                        saveUserToCSV(user);
                        break;
                    case 1:
                        System.out.printf("Enter new name for %s:\n", user.getUsername());
                        name = scnr.nextLine();
                        user.setName(name);
                        break;
                    case 2:
                        System.out.printf("Enter new email for %s:\n", user.getUsername());
                        email = scnr.nextLine();
                        user.setEmail(email);
                        break;
                    case 3:
                        System.out.printf("Enter new password for %s:\n", user.getUsername());
                        password = scnr.nextLine();
                        user.setPassword(password);
                        break;
                    case 4:
                        String miscType = (user instanceof Patient) ? "notes" : "department"; // if else shorthand!
                        System.out.printf("Enter new %s for %s:\n", miscType, user.getUsername());
                        misc = scnr.nextLine();
                        if (user instanceof Patient) {
                            ((Patient)user).setNotes(misc);
                        } else if (user instanceof Staff) {
                            ((Staff)user).setDepartment(misc);
                        }
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERROR! " + e.getMessage());
            }
        }
    }

    /**
     * saves a user to CSV
     * @param user
     */
    private static void saveUserToCSV(User user) {
        int id = user.getId();
        String filePath = (user instanceof Patient) ? "patient.csv" : "medicalstaff.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
            ArrayList<String> entries = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null ) {
                Scanner scnr = new Scanner(line); scnr.useDelimiter(",");
                int currId = scnr.nextInt();
                if (currId != id) {
                    // line is fine to write as is.
                    entries.add(line);
                } else if (currId == id) {
                    // we need to write the new values of user to the csv.
                    line = String.format("%d,%s,%s,%s,%s,", id, user.getUsername(), user.getPassword(), user.getName(),
                    user.getEmail());
                    if (user instanceof Patient) {
                        line += ((Patient)user).getNotes();
                    } else if (user instanceof Staff) {
                        line += ((Staff)user).getDepartment();
                    }
                    scnr.close();
                    entries.add(line);
                }
            } // end of while loop
            br.close(); //Dont forget to close!
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            // write lines to file
            for (int i = 0; i < entries.size()-1; i++) {
                bw.write(entries.get(i)); bw.newLine();
            } bw.write(entries.get(entries.size()-1));
            bw.close();
        } catch (IOException e) {
            System.out.println("Error reading/writing file! " + e.getMessage()); 
        }
    }

    public void printAllPatients() {
        System.out.println("LIST OF PATIENTS:");
        for (Patient pat : list) {
            System.out.printf("  %d - %s (%s)\n", pat.getId(), pat.getName(), pat.getEmail());
        }
    }
    public void printAllPatientsNameAscending() {
        ArrayList<Patient> tempList = (ArrayList<Patient>)list.clone(); // gives warning, but I know this is fine.
        for (int i = 0; i < tempList.size()-1; i++) {
            int minIdx = i; // assume i is lowest
            for (int k = i+1; k < tempList.size(); k++) {
                if (tempList.get(k).getName().compareTo(tempList.get(minIdx).getName()) < 0) {
                    minIdx = k;
                }
            }
            // swap
            Patient temp = tempList.get(i);
            tempList.set(i, tempList.get(minIdx)); // lowest goes to back
            tempList.set(minIdx, temp); // previous goes to front
        }
        System.out.println("LIST OF PATIENTS (ALPHEBETICAL):");
        for (Patient pat : tempList) {
            System.out.printf("  %d - %s (%s)\n", pat.getId(), pat.getName(), pat.getEmail());
        }
    }
    public void printAllEmails() {
        ArrayList<String> emails = new ArrayList<>();
        // add all emails from patients
        for (Patient pat : list) {
            emails.add(pat.getEmail());
        } try (Scanner fileScnr = new Scanner(new File("medicalstaff.csv"))) {
            fileScnr.useDelimiter(",");
            while (fileScnr.hasNextLine()) {
                fileScnr.next(); fileScnr.next(); fileScnr.next(); fileScnr.next();
                emails.add(fileScnr.next());
                fileScnr.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error reading staff csv!" + e.getMessage());
        }
        for (int i = 0; i < emails.size()-1; i++) {
            int minIdx = i; // assume lowest
            for (int k = i+1; k < emails.size(); k++) {
                if (emails.get(k).charAt(0) < emails.get(minIdx).charAt(0)) {
                    minIdx = k;
                }
            }
            String temp = emails.get(i);
            emails.set(i, emails.get(minIdx));
            emails.set(minIdx, temp);

        }
        System.out.println("LIST OF EMAILS:");
        for (String e : emails) {
            System.out.println("  " + e);
        }
    }

    public User getUser() {
        return user;
    }
    public Patient getSelected() {
        return selected;
    }
    public boolean isStaff() {
        return isStaff;
    }
    
}
