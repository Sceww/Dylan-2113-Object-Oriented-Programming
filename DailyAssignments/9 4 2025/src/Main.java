public class Main {
    public static void main(String[] args) {
        BankAccount a1;

        if (args.length == 2) {
            a1 = new BankAccount(args[0], Double.parseDouble(args[1]));
        } else {
            a1 = new BankAccount();
        }

        
        a1.deposit(50);
        a1.withdraw(30);
        
        BankAccount a2 = new BankAccount(a1);
        a2.withdraw(10_000);

        System.out.println(a1);
        System.out.println(a2);
    }
}
