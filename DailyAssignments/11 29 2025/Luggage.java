class Luggage {
    private String passengerName;
    private double weight;

    public Luggage(String name, double weight) {
        this.passengerName = name;
        this.weight = weight;
    }

    public String toString() {
        return String.format("  %s - %.1f kg", passengerName, weight);
    }

    static void selectionSortByWeight(Luggage[] bags) {
        for (int i = 0; i < bags.length-1; i++) {
            int minIdx = i; // assume i has the lowest value
            for (int k = i+1; k < bags.length; k++) { // starting from the next value of i;
                if (bags[k].weight < bags[minIdx].weight) { // if next value is lower than minIdx;
                    minIdx = k;
                }
            }
            // swap
            Luggage temp = bags[i];
            bags[i] = bags[minIdx];
            bags[minIdx] = temp; 
        }
    }
    static void selectionSortRecursiveByWeight(Luggage[] bags, int startIdx) {
        if (startIdx == bags.length-1) { return; /* Nothing to compare against! */}
        if (startIdx < 0) { startIdx = 0; }
        if (bags[startIdx].weight > bags[startIdx+1].weight) {
            Luggage temp = bags[startIdx];
            bags[startIdx] = bags[startIdx+1];
            bags[startIdx+1] = temp;
            selectionSortRecursiveByWeight(bags, startIdx-1);
        } else {
            selectionSortRecursiveByWeight(bags, startIdx+1);
        }
    }
    static void selectionSortByName(Luggage[] bags) {
        for (int i = 0; i < bags.length-1; i++) {
            int minIdx = i; // assume i has the lowest value
            for (int k = i+1; k < bags.length; k++) { // starting from the next value of i;
                if (bags[k].passengerName.compareToIgnoreCase(bags[minIdx].passengerName) < 0) { // if next value is lower than minIdx;
                    minIdx = k;
                }
            }
            // swap
            Luggage temp = bags[i];
            bags[i] = bags[minIdx];
            bags[minIdx] = temp; 
        }
    }


    static void printList(Luggage[] list, String message) {
        System.out.println(message);
        for (Luggage l : list) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        Luggage[] baseline = {
            new Luggage("Olivia", 23.4),
            new Luggage("Marcus", 15.2),
            new Luggage("Sophia", 32.8),
            new Luggage("Daniel", 18.9),
            new Luggage("Harper", 27.1),
        };

        Luggage[] recursive = baseline.clone();

        printList(baseline, "Unsorted");
        
        selectionSortByWeight(baseline);
        printList(baseline, "Selection Sort");
        
        selectionSortRecursiveByWeight(recursive, 0);
        printList(recursive, "Selection Sort (Recursive)");

        selectionSortByName(baseline);
        printList(baseline, "Selection Sort Alphebetically");

    }
}