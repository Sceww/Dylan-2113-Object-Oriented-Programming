package com.System;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner systemIn = new Scanner(System.in);
        Login log = new Login(systemIn);
        
        PatientManager man = log.login();

        if (man == null) {
            systemIn.close();
            System.out.println("PatientManager failed to initialize!");
            main(args);
        } /* else */
        
        menu(systemIn, man);

        systemIn.close();
    }

    public static void menu(Scanner scnr, PatientManager man) {
        boolean runMenu = true;
        while (runMenu) {
            System.out.printf("""
            
            -- User Management System --
            Current user: %s
            1. view user's attributes
            2. edit user's attributes\n""", man.getUser().getUsername());
            if (man.isStaff()) {
                if (man.getSelected() != null) {
                    System.out.printf("-- Patient Editing System --\nCurrent patient - %s\n", man.getSelected().getName());
                } else {
                    System.out.println("-- Patient Editing System --");
                }
            System.out.println("""
            3. view all patients
            4. view all patients (Alphebetical)
            5. view all emails
            6. select a patient
            7. view patient's attributes
            8. edit patient's attributes""");
            }
            System.out.print("0. Exit\n> ");
            try {
                int choice = Integer.parseInt(scnr.nextLine());
                switch (choice) {
                    case 0:
                        runMenu = false;
                        break;
                    case 1:
                        System.out.println(man.getUser());
                        break;
                    case 2:
                        PatientManager.editUserAttributes(man.getUser(), scnr);
                        break;
                    case 3:
                        if (!man.isStaff()) { System.out.println("Please enter an option."); break; }
                        man.printAllPatients();
                        break;
                    case 4:
                        if (!man.isStaff()) { System.out.println("Please enter an option."); break; }
                        man.printAllPatientsNameAscending();
                        break;
                    case 5:
                        if (!man.isStaff()) { System.out.println("Please enter an option."); break; }
                        man.printAllEmails();
                        break;
                    case 6:
                        if (!man.isStaff()) { System.out.println("Please enter an option."); break; }
                        System.out.print("Enter in a patient's ID: ");
                        int id = Integer.parseInt(scnr.nextLine());
                        man.selectPatient(id);
                        break;
                    case 7:
                        if (!man.isStaff()) { System.out.println("Please enter an option."); break; }
                        if (man.getSelected() == null) { System.out.println("Warning! No patient selected!"); break; }
                        System.out.println(man.getSelected());
                        break;
                    case 8:
                        if (!man.isStaff()) { System.out.println("Please enter an option."); break; }
                        if (man.getSelected() == null) { System.out.println("Warning! No patient selected!"); break; }
                        PatientManager.editUserAttributes(man.getSelected(), scnr);
                        break;
                    default:
                        System.out.println("Please enter an option.");
                        break;
                }
            } catch (UserNotFoundException e) {
                System.out.println("UserNotFoundException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a number. " + e);
            }
        }
    }

}