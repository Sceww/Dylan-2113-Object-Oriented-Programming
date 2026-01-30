public class Main {
    public interface Test {
        public int doSomething();
    }

    public static void main(String[] args) {
        Test anonInstance = new Test() {
            // public int yada = 1 -- NOT accessible to outside, but can probably be used inside.
            public int doSomething() {
                return 10;
            }
            public String doElse() {
                return "Wow!" + HelperFunction();
            }
            private int HelperFunction() {
                return -4;
            }
        };

        System.out.println(anonInstance.doSomething()); // ACCEPTABLE
        // System.out.println(anonInstance.doElse()); CANNOT do; doElse() is NOT defined in the class 'Main.Test'
    }
}