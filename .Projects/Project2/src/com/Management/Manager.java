package com.Management;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.Media.*;

/**
 * Class to manage media.
 */
public class Manager {
    private static ArrayList<Media> list = new ArrayList<>();

    public static int productCount() {
        return list.size();
    }

    // The following four methods could be one generic method?
    public static int movieCount() {
        int count = 0;
        
        for (Media m : list) {
            if (m instanceof Movie) {
                count++;
            }
        }
        return count;
    }
    public static int tvShowCount() {
        int count = 0;

        for (Media m : list) {
            if (m instanceof TVShow) {
                count++;
            }
        }
        return count;
    }
    public static int videoGameCount() {
    int count = 0;

    for (Media m : list) {
        if (m instanceof VideoGame) {
            count++;
        }
    }
    return count;
}
    public static int musicAlbumCount() {
    int count = 0;

    for (Media m : list) {
        if (m instanceof MusicAlbum) {
            count++;
        }
    }
    return count;
}
    
    public static Media getOldestProduct() {
        Media oldest = list.get(0);
        for (Media m : list) {
            if (m.getReleaseYear() < oldest.getReleaseYear()) {
                oldest = m;
            }
        } 
        return oldest;
    }

    // The following two methods could be one generic method?
    public static MusicAlbum getTopMusicAlbum() {
        int salesNum = 0;
        MusicAlbum top = null;
        for (Media m : list) {
            if (m instanceof MusicAlbum) {
                MusicAlbum album = (MusicAlbum)m;
                if (album.getGlobalSales() > salesNum) {
                    salesNum = album.getGlobalSales();
                    top = album;
                }
            }
        }
        return top;
    }
    public static VideoGame getTopVideoGame() {
        double salesNum = 0.0;
        VideoGame top = null;
        for (Media m : list) {
            if (m instanceof VideoGame) {
                VideoGame game = (VideoGame) m;
                if (game.getCopiesSold() > salesNum) {
                    salesNum = game.getCopiesSold();
                    top = game;
                }
            }
        }
        return top;
    }

    // How can I use generic methods for this one?
    public static String averageFilmAgeRating() {
        /*
         * Age ratings: (Descending)
         * TV-MA, 4
         * TV-14, 3
         * PG-13, 2
         * TV-PG, 1
         * TV-Y7  0 
         */
        return "";
    }

    // The following two methods could possibly be one generic method?
    public static Movie shortestMovie() {
        Movie shortest = null;
        // find the first movie.
        for (Media m : list) {
            if (m instanceof Movie) {
                shortest = (Movie)m;
                break;
            }
        }
        // Find the shortest movie
        for (Media m : list) {
            if (m instanceof Movie) {
                Movie movie = (Movie) m;
                if (movie.getDuration() < shortest.getDuration()) {
                    shortest = movie; 
                }
            }
        }
        return shortest;
    }
    public static MusicAlbum shortestAlbum() {
        MusicAlbum shortest = null;
        // find the first MusicAlbum.
        for (Media m : list) {
            if (m instanceof MusicAlbum) {
                shortest = (MusicAlbum)m;
                break;
            }
        }
        // Find the shortest MusicAlbum
        for (Media m : list) {
            if (m instanceof MusicAlbum) {
                MusicAlbum album = (MusicAlbum) m;
                if (album.getDuration() < shortest.getDuration()) {
                    shortest = album; 
                }
            }
        }
        return shortest;
    }


    public static void addMedia(Media media) {
        System.out.print(media);
        list.add(media);
    }

    public static void scanCSV(String dataFileName) {
        try ( FileInputStream dataSet = new FileInputStream(dataFileName); Scanner dataSetScnr = new Scanner(dataSet) ) {
            dataSetScnr.useDelimiter(",");

            while (dataSetScnr.hasNextLine()) {
                // check if line is empty.
                String line = dataSetScnr.nextLine();
                if ( !line.isEmpty() ) {
                    Scanner lineScnr = new Scanner(line);
                    lineScnr.useDelimiter(",");
                    // Check if the entry follows rules
                    if (lineScnr.hasNextInt()) {
                        // print ID for debugging
                        System.out.print("ID " + lineScnr.nextInt() + ": ");
                        
                        // read type, then create type
                        switch (lineScnr.next()) {
                            case "Movie":
                                addMedia(new Movie(lineScnr));
                                break;
                            case "Music Album":
                                addMedia(new MusicAlbum(lineScnr));
                                break;
                            case "TV Show":
                                addMedia(new TVShow(lineScnr));
                                break;
                            case "Video Game":
                                addMedia(new VideoGame(lineScnr));
                                break;
                            default:
                                System.out.print("!!! WARNING : JUNK DATA; ENTRY SKIPPED!!!");
                                break;
                        }
                        System.out.println();
                        }
                        lineScnr.close();
                    }
                }
                dataSetScnr.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
