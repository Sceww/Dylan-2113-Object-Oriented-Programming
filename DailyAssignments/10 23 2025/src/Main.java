public class Main {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("ABC123", 500.0);

        myAccount.deposit(200.00);

        try {
            myAccount.withdraw(800.00);
        } catch (InsufficientFundsException e) {
            System.out.printf("Exception caught! : [%s]\n", e);
        }

        System.out.println("Transaction Process Complete");

    }
}
