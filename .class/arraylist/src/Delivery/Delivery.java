package Delivery;
import java.util.ArrayList;

public class Delivery {

    /**
     * A function that does nothing good
     * @param a - A
     * @param b - B
     * @return The sum of A and B
     */
    public static int exampleFunc(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        ArrayList<String> packages = new ArrayList<>();

        packages.add("PKG101");
        packages.add("PKG102");
        packages.add("PKG103");
        packages.add("PKG104");
        packages.add("PKG105");
        
        exampleFunc(2, 3);
        
        packages.add(2, "PKG106");
        packages.set(0, "PKG999");

        System.out.println(packages.size());
        System.out.println(packages.contains("PKG103"));
        System.out.println(packages.isEmpty());

        for (String code: packages) {
            System.out.println(code);
        }
    }
}