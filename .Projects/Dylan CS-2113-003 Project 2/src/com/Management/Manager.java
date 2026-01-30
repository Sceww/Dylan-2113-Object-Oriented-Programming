import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.Media.Interface.*;
import com.Media.*;
import Exception.MediaNotFoundException;

public class Manager {
    ArrayList<Media> list = new ArrayList<>();

    /**
     * Reads A CSV file and reads media into the arraylist
     * @param filePath
     */
    public void readCSV(String filePath) throws FileNotFoundException, IOException, InputMismatchException {
        try (FileInputStream CSV = new FileInputStream(filePath); Scanner scnr = new Scanner(CSV)) {
            scnr.useDelimiter(",");
            while (true) {
                // Read row ID
                try {
                    // We know that every entry begins with a number ID.
                    // If there isn't a number ID, then we are done scanning.
                    scnr.nextInt();
                } catch (Exception e) {
                    return;
                }

                // Read type
                String type = scnr.next().toLowerCase();
                String line = scnr.nextLine();
                switch (type) {
                    case "movie":
                        Movie movie = new Movie(new Scanner(line));
                        // System.out.printf("Reading new %s: %s\n", movie.getType(), movie.getTitle());
                        list.add(movie);
                        break;
                    case "video game":
                        VideoGame videogame = new VideoGame(new Scanner(line));
                        // System.out.printf("Reading new %s: %s\n", videogame.getType(), videogame.getTitle());
                        list.add(videogame);
                        break;
                    case "music album":
                        Album album = new Album(new Scanner(line));
                        // System.out.printf("Reading new %s: %s\n", album.getType(), album.getTitle());
                        list.add(album);
                        break;
                    case "tv show":
                        TVShow tvshow = new TVShow(new Scanner(line));
                        // System.out.printf("Reading new %s: %s\n", tvshow.getType(), tvshow.getTitle());
                        list.add(tvshow);
                        break;
                    default:
                        throw new InputMismatchException("CSV reader: Invalid media Type!");
                }
            }
        } 
    }

    public int getProductCount() {
        return list.size();
    } 

    /**
     * Accepted types:
     * "TV Show"
     * "Movie"
     * "Video Game"
     * "Music Album" 
     * @param type
     * @return
     * @throws InputMismatchException
     */
    public int getTypeProductCount(String type) throws InputMismatchException {
        isValidType(type);

        int count = 0;
        for (Media m : list) {
            if (m.getType().toLowerCase().equals(type.toLowerCase())) { // Tried to use a generic method here, but Java doesn't work like that! Strings it is.
                count++;
            }
        }
        return count;
    }

    public Album getMostPopularAlbum() throws MediaNotFoundException { // These methods are so incredibly similar, but I cant figure out how to combine these since casting to T isn't possible.
        boolean first = true;
        Album top = null;
        for (Media m : list) {
            if (m instanceof Album) {
                if (first) {top = (Album)m; first = false;}
                Album album = (Album)m;
                if (album.getGlobalSales() > top.getGlobalSales()) {
                    top = album;
                }
            }
        }
        if (top == null) {
            throw new MediaNotFoundException("Album not found");
        }
        return top;
    }

    public VideoGame getMostPopularVideoGame() throws MediaNotFoundException {
        boolean first = true;
        VideoGame top = null;
        for (Media m : list) {
            if (m instanceof VideoGame) {
                if (first) {top = (VideoGame)m; first = false;}
                VideoGame game = (VideoGame)m;
                if (game.getMillionsSold() > top.getMillionsSold()) {
                    top = game;
                }
            }
        }
        if (top == null) {
            throw new MediaNotFoundException("Video game not found");
        }
        return top;
    }

    public String getMostCommonRating() throws MediaNotFoundException {
        // Builds a list of the ratings of Film classes. Each member of the list should be unique (no repeats). If a String is already found in the list,
        // a seperate list containing the counts of the ratings is incremented.
        // Finally, return the entry with the most amount ratings.
        ArrayList<String> ratingsList = new ArrayList<>();
        ArrayList<Integer> ratingsCount = new ArrayList<>();
        
        // finding ratings
        for (Media m : list) {
            if (m instanceof Film) {
                Film film = (Film)m;
                String rating = film.getRating();
                // check if rating is already in list
                if (!ratingsList.contains(rating)) {
                    ratingsList.add(rating);
                    ratingsCount.add(1);
                } else {
                    int idx = ratingsList.indexOf(rating);
                    ratingsCount.set(idx, ratingsCount.get(idx).intValue() + 1);
                }
            }
        }
        // check if anything even exists
        if (ratingsList.isEmpty()) {
            throw new MediaNotFoundException("No film media found!");
        }
        // evaluating ratings
        int topIndex = 0;
        String top = ratingsList.get(topIndex);
        int topValue = ratingsCount.get(topIndex).intValue();
        for (int idx = 0; idx < ratingsList.size(); idx++) {
            // if current rating's associated count is higher than the top, replace it
            String currRating = ratingsList.get(idx);
            int currValue = ratingsCount.get(idx).intValue();
            if (currValue > topValue) {
                top = currRating;
                topValue = currValue;
            }
        }
        return String.format("%s with %d occurrences!", top, topValue);    
    }

    public Movie getShortestMovie() throws MediaNotFoundException {
        boolean first = true;
        Movie shortest = null;
        for (Media m : list) { 
            if (m instanceof Movie) {
                if (first) {shortest = (Movie)m; first = false;}
                Movie movie = (Movie)m;
                if (movie.getDuration() < shortest.getDuration()) {
                    shortest = movie;
                }
            }
        }
        if (shortest == null) {
            throw new MediaNotFoundException("Movie not found!");
        }
        return shortest;
    } 
    
    public Album getShortestAlbum() throws MediaNotFoundException {
        boolean first = true;
        Album shortest = null;
        for (Media m : list) {
            if (m instanceof Album) {
                if (first) {shortest = (Album)m; first = false;}
                Album album = (Album)m;
                if (album.getDuration() < shortest.getDuration()) {
                    shortest = album;
                }
            }
        }
        if (shortest == null) {
            throw new MediaNotFoundException("Album not found!");
        }
        return shortest;
    }

    public Media getOldestMedia() {
        Media oldest = list.get(0);
        for (Media m : list) {
            if (m.getReleaseYear() < oldest.getReleaseYear()) {
                oldest = m;
            }
        }
        return oldest;
    }

    /**
     * Returns true if the given type is valid, else it will throw an exception.
     * 
     * @param type
     * @return boolean
     */
    private boolean isValidType(String type) throws InputMismatchException {
        switch (type.toLowerCase()) {
            case "tv show": break;
            case "movie": break;
            case "video game": break;
            case "music album": break;

            default:
                throw new InputMismatchException("Invalid Media type! Please check your spelling...");
        }
        return true;
    }
}
