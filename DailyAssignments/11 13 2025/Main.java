public class Main {
    
    static int totalWeightLinear(int[] w, int start, int end) {
        if (start > end) { return 0; };
        int value = w[start];
        return value + totalWeightLinear(w, start + 1, end);
    }

    static int totalWeightDivide(int[] w, int start, int end) {
        if (start == end) { return w[start]; }
        
        int length = (end - start) / 2;
        int midpoint = start + length;

        int t = 0;
        for (int i = start; i <= midpoint; i++ ) {
            t += w[i];
        }

        return t + totalWeightDivide(w, midpoint + 1, end);
    }

    public static void main(String[] args) {
        int[] weights = { 2, 5, 3, 1, 4, 6, 2, 7 };
        int a = totalWeightLinear(weights, 0, 7);
        System.out.println("Linear: " + a);
        int b = totalWeightDivide(weights, 0, 7);
        System.out.println("Division: " + b);
    }
}