public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount() {
        this("Dylan Guzman", 0.0);
    }

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public BankAccount(BankAccount account) {
        this.owner = account.owner;
        this.balance = account.balance;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.isEmpty()) {
            System.out.println("Owner must have a name!");
            return;
        }
        this.owner = owner;
    }
    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance cannot be negative!");
            return;
        }
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative values!");
            return;
        }
        this.balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Cannot withdraw negative values!");
            return false;
        } else if (amount > balance) {
            System.out.println("Insufficient funds...");
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("BankAccount{owner=%s, balance=%.2f}", owner, balance);
    }

}