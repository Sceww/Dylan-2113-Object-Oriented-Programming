import java.util.InputMismatchException;
import java.util.Scanner;

import com.Media.Interface.Media;

import Exception.MediaNotFoundException;

import com.Media.*;

public class Driver {
    public static void main(String[] args) {
        Manager man = new Manager();
        Scanner scnr = new Scanner(System.in);

        System.out.printf("Please Enter the Filepath of the CSV file\n> ");
        String filePath = scnr.nextLine();
        scnr.close();

        try {
            System.out.println("=== READING CSV ===");
            man.readCSV(filePath);
        } catch (Exception e) {
            System.out.println("ERROR READING CSV! Exiting program...\n" + e.getMessage());
            return;
        }
        System.out.println("=== DONE READING CSV ===\n");
        
        // Total products test
        System.out.printf("Total products in list: %d\n", man.getProductCount());

        // Count types test
        String[] array = {"Movie", "TV Show", "Video Game", "Music Album"};
        for (String s : array) {
            try {
                System.out.printf("Total %ss in list: %d\n", s, man.getTypeProductCount(s));
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        // Find oldest test
        Media oldest = man.getOldestMedia();
        System.out.printf("Oldest Product in list: %s, released in %d\n", oldest.getTitle(), oldest.getReleaseYear());

        // Find most popular Music / Game tests
        try {
            Album popAlbum = man.getMostPopularAlbum();
            System.out.printf("Most popular Music Album: %s, by %s, with %d sales!\n", popAlbum.getTitle(), popAlbum.getArtist(), popAlbum.getGlobalSales());
            VideoGame popVideoGame = man.getMostPopularVideoGame();
            System.out.printf("Most popular Video Game: %s, by %s, with %.2f million sales!\n", popVideoGame.getTitle(), popVideoGame.getPublisher(), popVideoGame.getMillionsSold());
        } catch (MediaNotFoundException e) {
            System.out.print(e.getMessage());
        }

        // Find most common age rating test
        try {
            System.out.printf("The most common age rating in film is: %s\n", man.getMostCommonRating());
        } catch (MediaNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Find shortest Movie / Album test
        try {
            Movie shortMovie = man.getShortestMovie();
            System.out.printf("Most shortest Movie: %s, by %s, with a length of %.2f minutes!\n", shortMovie.getTitle(), shortMovie.getDirector(), shortMovie.getDuration());
            Album shortAlbum = man.getShortestAlbum();
            System.out.printf("Most shortest Music Album: %s, by %s, a length of %.2f minutes!\n", shortAlbum.getTitle(), shortAlbum.getArtist(), shortAlbum.getDuration());
        } catch (MediaNotFoundException e) {
            System.out.print(e.getMessage());
        }

        System.out.println("Program is now finished running!");
        return;
    }
}
