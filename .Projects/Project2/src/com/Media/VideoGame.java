package com.Media;

import java.util.Scanner;

public class VideoGame extends Media {
    String type = "Video Game";
    String title;
    String platform;
    int releaseYear;
    String genre;
    String publisher;
    double copiesSold;

    public VideoGame(Scanner lineScnr) {
        super(lineScnr);
        title = lineScnr.next();
        platform = lineScnr.next();
        releaseYear = lineScnr.nextInt();
        genre = lineScnr.next();
        publisher = lineScnr.next();
        copiesSold = lineScnr.nextDouble();
    }

    public double getCopiesSold() {
        return this.copiesSold;
    }
}
