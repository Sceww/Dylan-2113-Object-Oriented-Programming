package com.Management;

/**
 * Class the user interacts with.
 */
public class Driver {
    public static void main(String[] args) {
        Manager.scanCSV("Project2_Dataset.csv");
        System.out.printf("There are %d product(s) in the list.\n", Manager.productCount());

    }
}
