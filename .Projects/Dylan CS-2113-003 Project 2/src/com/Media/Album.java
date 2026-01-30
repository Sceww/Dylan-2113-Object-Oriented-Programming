package com.Media;

import java.util.Scanner;

import com.Media.Interface.Duration;
import com.Media.Interface.Genre;
import com.Media.Interface.Media;

public class Album extends Media implements Duration, Genre {
    // Media attributes
    private String title;
    private int releaseYear;

    // Album attributes
    private String artist;
    private int globalSales;
    private int tracks;

    // Interface attributes
    private double duration;
    private String genre;

    /**
     * Constructor for the class. Scanner is closed by the constructor.
     * @param scnr
     */
    public Album(Scanner scnr) {
        super(scnr);
        releaseYear = scnr.nextInt();
        artist = scnr.next();
        title = scnr.next();
        globalSales = scnr.nextInt();
        tracks = scnr.nextInt();
        duration = scnr.nextDouble();
        genre = scnr.next();
        scnr.close();
    }

    // Album methods
    public String getArtist() {
        return artist;
    }
    public int getGlobalSales () {
        return globalSales;
    }
    public int getTracks() {
        return tracks;
    }

    // Media methods
    @Override
    public String getType() {
        return "Music Album";
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public int getReleaseYear() {
        return releaseYear;
    }
    
    // Interface methods
    @Override
    public double getDuration() {
        return duration;
    }
    @Override
    public String getGenre() {
        return genre;
    }
    

}
