package com.Media;

import java.util.Scanner;

public class Film extends Media {
    String title;
    String director;
    String country;
    int releaseYear;
    String ageRating;
    // double duration; // String numberSeasons
    String description;
    public Film(Scanner scnr) {
        super(scnr);
    }

    public String getAgeRating() {
        return ageRating;
    }

}
