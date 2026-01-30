package com.Media;

import java.util.Scanner;

import com.Media.Interface.Film;

public class TVShow extends Film {

    
    // Media attributes
    private String title;
    private int releaseYear;
    
    // TVShow attributes
    private String numberSeasons;
    
    // Interface attributes
    private String director;
    private String country;
    private String rating;
    private String description;
    
    /**
     * Constructor for the class. Scanner is closed by the constructor.
     * @param scnr
     */
    public TVShow(Scanner scnr) {
        //id,type,title,director,country,release_year,rating,number_of_seasons,description
        super(scnr);
        title = scnr.next();
        director = scnr.next();
        country = scnr.next();
        releaseYear = scnr.nextInt();
        rating = scnr.next();
        numberSeasons = scnr.next();
        description = scnr.next(); // Since scnr is using the delimiter ',', the next complete token is the entirety of the contents within ','.
        scnr.close();
    }
    
    // TVShow methods
    public String getNumberOfSeasons() {
        return numberSeasons;
    }

    // Media methods
    @Override
    public String getType() {
        return "TV Show";
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
    public String getDescription() {
        return description;
    }   
    
}
