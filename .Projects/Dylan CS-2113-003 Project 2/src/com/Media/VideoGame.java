package com.Media;

import java.util.Scanner;

import com.Media.Interface.*;

public class VideoGame extends Media implements Genre {

    
    // Media attributes
    private String title;
    private int releaseYear;
    
    // VideoGame attributes
    private String platform;
    private double millionsSold;
    private String publisher;
    
    // Interface attributes
    private String genre;

    /**
     * Constructor for the class. Scanner is closed by the constructor.
     * @param scnr
     */
    public VideoGame(Scanner scnr) {
        //id,type,title,platform,release_year,genre,publisher,copies_sold_(millions)
        super(scnr);
        title = scnr.next();
        platform = scnr.next();
        releaseYear = scnr.nextInt();
        genre = scnr.next();
        publisher = scnr.next();
        millionsSold = scnr.nextDouble();
        scnr.close();
    }

    // VideoGame methods
    public String getPublisher() {
        return publisher;
    }
    public String getPlatform() {
        return platform;
    }
    public double getMillionsSold() {
        return millionsSold;
    }

    // Media methods
    @Override
    public String getType() {
        return "Video Game";
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
    public String getGenre() {
        return genre;
    }
}
