public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("Deposited: %.2f | New Balance: %.2f\n", amount, balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Transaction failed: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f | New Balance: %.2f\n", amount, balance);
        }
    }
}
