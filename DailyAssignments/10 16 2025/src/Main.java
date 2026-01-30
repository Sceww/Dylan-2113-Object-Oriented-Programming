import java.util.ArrayList;
import java.util.Scanner;

import com.Vehicles.*;

public class Main {
    private static int readPositiveInt(Scanner scanner, String type) {
        System.out.print("Please enter the number of days you'd like to rent: ");
        String line = scanner.nextLine();
        Scanner scnr = new Scanner(line);

        if (scnr.hasNextInt()) {
            int value = scnr.nextInt();
            if (value >= 0) {
                scnr.close();
                return value; // success!
            }
        } // else:  
        scnr.close();

        System.out.println("Please enter a postive number.");
        readPositiveInt(scanner, type);
        
        return -1; // should never happen...
    }
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Car("Mazda", "3", 60.0));
        vehicleList.add(new Bike("Yamaha", "R15", 25.0));
        vehicleList.add(new Truck("Ford", "F150", 120.0));

        Scanner scnr = new Scanner(System.in);

        for (Vehicle vehicle : vehicleList) {
            System.out.printf("%s: ", vehicle.getType());
            vehicle.displayInfo();
            
            int days = readPositiveInt(scnr, vehicle.getType());

            System.out.printf("Total cost for renting the %s %s for %d day(s): $%.2f\n\n", 
                                                            vehicle.getBrand(), vehicle.getModel(), days, vehicle.calculateRentalCost(days));
        }
        scnr.close();
    }
}
