package com.Media;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TVShow extends Film {
    String type = "TVShow";
    String title;
    String director;
    String country;
    int releaseYear;
    String ageRating;
    String numberSeasons;
    String description;

    public TVShow(Scanner lineScnr) throws InputMismatchException {
        super(lineScnr);
        title = lineScnr.next();
        director = lineScnr.next();
        country = lineScnr.next();
        releaseYear = lineScnr.nextInt();
        ageRating = lineScnr.next();
        numberSeasons = lineScnr.next();
        description = lineScnr.nextLine();
    }
}
