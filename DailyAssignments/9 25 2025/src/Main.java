import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        boolean finished = false;

        FileWriter writeToFile = new FileWriter("output.txt");
        
        
        System.out.println("Enter text (type 'stop' to finish):");
        
        // === Creating text file === //
        Scanner scnr = new Scanner(System.in);
        while (!finished) {
            String msg = scnr.nextLine();
            if (!msg.equals("stop")) {
                writeToFile.append(msg + "\n");
            } else { finished = true; }
        }
        writeToFile.flush();
        writeToFile.close();

        // === Reading text file ==== //
        System.out.println("\nREADING FILE FROM DISK NOW.\n");
        FileReader readFromFile = new FileReader("output.txt"); // reads chars from a file, chars are stored in UTF-8 encoding format by default (?)
        
        int i;
        while ( (i = readFromFile.read()) != -1 ) { // FileReader returns a value of -1 if EOF.
            System.out.print( (char) i );
        }

        readFromFile.close();
    }
}