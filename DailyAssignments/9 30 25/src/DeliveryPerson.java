public class DeliveryPerson extends Person {
    private int deliveriesCompleted;
    private double ratePerDelivery;

    public DeliveryPerson(String name, int age, int deliveriesCompleted, double rate) {
        super(name, age);
        this.deliveriesCompleted = deliveriesCompleted;
        this.ratePerDelivery = rate;
    }

    double calculateSalary() {
        return ratePerDelivery * deliveriesCompleted;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Deliveries completed: " + deliveriesCompleted);
        System.out.printf("Salary: $%.2f\n", calculateSalary());
    }
}