package com.Media;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Media.Interfaces.*;

public class Movie extends Film implements Duration {
    String type = "Movie";
    String title;
    String director;
    String country;
    int releaseYear;
    String ageRating;
    double duration;
    String description;
    
    public Movie(Scanner lineScnr) throws InputMismatchException {
        super(lineScnr);
        title = lineScnr.next();
        director = lineScnr.next();
        country = lineScnr.next();
        releaseYear = lineScnr.nextInt();
        ageRating = lineScnr.next();
        duration = lineScnr.nextDouble();
        description = lineScnr.nextLine();
    }

    public double getDuration() {
        return duration;
    }
}