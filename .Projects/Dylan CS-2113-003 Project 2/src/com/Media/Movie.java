package com.Media;

import java.util.Scanner;

import com.Media.Interface.Duration;
import com.Media.Interface.Film;

public class Movie extends Film implements Duration {
    // Media attributes
    private String title;
    private int releaseYear;
    
    
    // Interface attributes
    private String director;
    private String country;
    private String rating;
    private double duration;
    private String description;
    
    /**
     * Constructor for the class. Scanner is closed by the constructor.
     * @param scnr
     */
    public Movie(Scanner scnr) {
        // Movie: id,type,title,director,country,release_year,rating,duration_(minutes),description
        super(scnr);
        title = scnr.next();
        director = scnr.next();
        country = scnr.next();
        releaseYear = scnr.nextInt();
        rating = scnr.next();
        duration = scnr.nextDouble();
        description = scnr.next(); // Since scnr is using the delimiter ',', the next complete token is the entirety of the contents within ','.
        scnr.close();
    }
    
    // Media methods
    @Override
    public String getType() {
        return "Movie";
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
    public String getDirector() {
        return director;
    }
    @Override
    public String getCountry() {
        return country;
    }
    @Override
    public String getRating() {
        return rating;
    }
    @Override
    public double getDuration() {
        return duration;
    }
    @Override
    public String getDescription() {
        return description;
    }   
    
}
