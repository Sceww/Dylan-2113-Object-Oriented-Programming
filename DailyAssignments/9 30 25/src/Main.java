public class Main {
    public static void main(String[] args) {
        DeliveryPerson alex = new DeliveryPerson("Alex Johnson", 29, 40, 5);
        DeliveryPerson sarah = new DeliveryPerson("Sarah Lee", 24, 30, 10);
        
        System.out.println("---Delivery Person 1---");
        alex.displayInfo();

        System.out.println("---Delivery Person 2---");
        sarah.displayInfo();
    }

}