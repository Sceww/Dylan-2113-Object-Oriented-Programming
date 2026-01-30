package com.Media.Interface;

import java.util.Scanner;

public abstract class Media {

    public Media(Scanner scnr) {
        // Forces the constructor of inherited classes to use comma delimiter.q
        scnr.useDelimiter(",");
    }
    
    public abstract String getType();
    public abstract String getTitle();
    public abstract int getReleaseYear();
}