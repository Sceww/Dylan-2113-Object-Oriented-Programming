package com.System;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.User.*;

public class Login {
    private Scanner scnr;

    public Login(Scanner scnr) {
        this.scnr = scnr;
    }

    /* asks user for patient / staff, returns a patient manager*/
    public PatientManager login() {
        System.out.print("\n1.) Patient Login\n2.) Staff Login\n> ");
        int choice;
        try {
            choice = Integer.parseInt( scnr.nextLine() );
            switch (choice) {
                case 1:
                    return patientLogin();
                case 2:
                    return staffLogin();
                default:
                    System.out.println("Please enter an option!");
            }
        } catch (UserNotFoundException e) {
            System.out.println("User not found, please try again.");
        } catch (WrongPasswordException e) {
            System.out.println("Wrong password, please try again.");
        } catch (Exception e) {
            System.out.println("Please select a valid option. (" + e.getMessage() + ")");
        }
        return login();
    }
    
    /**
     * returns a string array containing the information of a user from a CSV
     * @param filePath
     * @throws UserNotFoundException
     * @throws WrongPasswordException
     */
    private String[] findUserByUsername(String filePath) throws UserNotFoundException, WrongPasswordException {
        /* asks the user for their username and password */
        System.out.println("Please enter your username: ");
        String tUser = scnr.nextLine();
        // Search for user in patient.csv
        try ( Scanner fileScnr = new Scanner(new File(filePath)) ) {
            fileScnr.useDelimiter(",");
            while (fileScnr.hasNextLine()) {
                String id = fileScnr.next();
                String username = fileScnr.next();
                String password = fileScnr.next();
                if (tUser.equals(username)) {
                    System.out.println("Please enter your password:");
                    if (password.equals(scnr.nextLine())) {
                        String name = fileScnr.next();
                        String email = fileScnr.next();
                        String misc = fileScnr.nextLine().substring(1);     

                        return new String[] {id, username, password, name, email, misc};
                    } else { throw new WrongPasswordException("Password entered was wrong!"); }
                } else {
                    // discard the rest of the current user entry
                    fileScnr.nextLine();
                }
            }
        } catch (IOException e) {
            System.out.print("Error opening file! " + e.getMessage());
            return null;
        }
        throw new UserNotFoundException("User not found!");
    }
    /* Login for patients */
    private PatientManager patientLogin() throws UserNotFoundException, WrongPasswordException {
        String[] userInfo = findUserByUsername("patient.csv");
        int id = Integer.parseInt(userInfo[0]);
        String username = userInfo[1];
        String password = userInfo[2];
        String name = userInfo[3];
        String email = userInfo[4];
        String notes = userInfo[5];

        return new PatientManager(new Patient(id, username, password, name, email, notes));
    }
    /* Login for staff members */
    private PatientManager staffLogin() throws UserNotFoundException, WrongPasswordException {
        String[] userInfo = findUserByUsername("medicalstaff.csv");
        int id = Integer.parseInt(userInfo[0]);
        String username = userInfo[1];
        String password = userInfo[2];
        String name = userInfo[3];
        String email = userInfo[4];
        String department = userInfo[5];

        return new PatientManager(new Staff(id, username, password, name, email, department));
    }
}
