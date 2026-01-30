package com.grocery.list;
import java.util.Scanner;

public class ListManager {
    public static void main(String[] args) {
        GroceryList list = new GroceryList();   // List class used by menu
        Scanner scnr = new Scanner(System.in);  // Scanner to scan terminal input
        boolean runMenu = true; // switched to false when exiting

        while (runMenu) {
            System.out.println("\nWelcome to grocery management!");
            System.out.println("1. Add item to list");
            System.out.println("2. Remove item from list");
            System.out.println("3.\"Check Off\" item from list");
            System.out.println("4. Display grocery list");
            System.out.println("5. Exit");
            System.out.print  ("Enter the number of an option above: > ");
            
            try {
                int input = scnr.nextInt();
                scnr.nextLine(); // Because nextInt leaves the '\n' character after the user's input; e.i. '3\n' -> '\n'
                switch (input) {
                case 1: // add item
                    System.out.println("Enter name of item to add: ");
                    list.addItem(scnr.nextLine());
                    break;
                case 2: // remove item
                    if (list.isEmpty()) {
                        System.out.println("List is empty!");
                        break;
                    }
                    System.out.println("Enter the name or item # to remove:");
                    list.removeItem(scnr.nextLine());
                    break;
                case 3: // check off item
                    if (list.isEmpty()) {
                        System.out.println("List is empty!");
                        break;
                    }
                    System.out.println("Enter the name or item # to check off:");
                    list.checkOffItem(scnr.nextLine());
                    break;
                case 4: // display list
                    list.printList();
                    break;
                case 5: // exit program
                    System.out.println("Exiting program...");
                    runMenu = false;
                    break;
                default: // int input, but no corresponding case
                    System.out.println("Please select an option.");
                    break;
            }
            } catch (Exception e) { // non-integer input
               System.out.println("Invalid input! Please enter a number!");
               scnr.nextLine();
            }
        }   
        
        scnr.close(); // close scanner
    }
}