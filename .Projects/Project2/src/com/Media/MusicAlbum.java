package com.Media;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Media.Interfaces.*;

public class MusicAlbum extends Media implements Duration {
    String type = "Music Album";
    int releaseYear;
    String artist;
    String title;
    int globalSales;
    int tracks;
    double duration;
    String genre;
    
    public MusicAlbum(Scanner lineScnr) throws InputMismatchException {
        super(lineScnr);
        releaseYear = lineScnr.nextInt();
        artist = lineScnr.next();
        title = lineScnr.next();
        globalSales = lineScnr.nextInt();
        tracks = lineScnr.nextInt();
        duration = lineScnr.nextDouble();
        genre = lineScnr.next();
    }

    public int getGlobalSales() {
        return globalSales;
    }

    public double getDuration() {
        return duration;
    }
}
