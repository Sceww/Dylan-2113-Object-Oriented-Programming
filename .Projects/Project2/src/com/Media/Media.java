package com.Media;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Media {
    String type;
    String title;
    int releaseYear;

    public Media(Scanner lineScnr) throws InputMismatchException {}
    // public abstract void readData(Scanner scnr);

    public int getReleaseYear() {
        return this.releaseYear;
    }
    
    public String toString() {
        return String.format("%s[title: %s, releaseYear: %d]", this.type, this.title, this.releaseYear);
    };
}
