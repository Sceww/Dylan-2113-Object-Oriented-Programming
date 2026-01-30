class Order {
    String customerName;
    double totalPrice;

    public Order(String c, double t) {
        customerName = c;
        totalPrice = t;
    }

    static void bubbleSortIterative(Order[] orders) {
        Order temp;

        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - 1; j++) {
                if (orders[j].totalPrice > orders[j+1].totalPrice) {
                    temp = orders[j+1];
                    orders[j+1] = orders[j];
                    orders[j] = temp;
                }
            }
        }
    }

    static void bubbleSortRecursive(Order[] orders, int n) {
        if (n >= orders.length - 1) { return; }
        if (n < 0) { n = 0; } 
        Order temp;

        if (orders[n].totalPrice > orders[n+1].totalPrice) {
            // swap next with current
            temp = orders[n+1];
            orders[n+1] = orders[n];
            orders[n] = temp;
            bubbleSortRecursive(orders, n - 1);
        } else {
            bubbleSortRecursive(orders, n + 1);
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", customerName, totalPrice);
    }

    public static void main(String[] args) {
        Order[] classic = {
            new Order("Alice", 59.99),
            new Order("Bob", 19.50),
            new Order("Charlie", 120.00),
            new Order("Diana", 42.75),
            new Order("Ethan", 85.20),
        };
        Order[] recursive = {
            new Order("Alice 2", 59.99),
            new Order("Bob 2", 19.50),
            new Order("Charlie 2", 120.00),
            new Order("Diana 2", 42.75),
            new Order("Ethan 2", 85.20),
        };

        System.out.println("Before sorting:");
        System.out.println("  Iterative:");
        for (Order order : classic) {
            System.out.println("    " + order);
        }
        System.out.println("  Recursive:");
        for (Order order : recursive) {
            System.out.println("    " + order);
        }

        Order.bubbleSortIterative(classic);
        Order.bubbleSortRecursive(recursive, 0);

        System.out.println("\nAfter sorting:");
        System.out.println("  Iterative:");
        for (Order order : classic) {
            System.out.println("    " + order);
        }
        System.out.println("  Recursive:");
        for (Order order : recursive) {
            System.out.println("    " + order);
        }

    }
}