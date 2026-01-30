package com.Media.Interface;

import java.util.Scanner;

public abstract class Film extends Media implements Director, Country, Rating, Description {
    public Film(Scanner scnr) {
        super(scnr);
    }
}  