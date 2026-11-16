abstract class Accounts {
    protected double balance;
    protected long accountNumber;
    protected String accountHoldersName;
    protected String address;

    // Constructor
    public Accounts(double balance, long accountNumber, String accountHoldersName, String address) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHoldersName = accountHoldersName;
        this.address = address;
    }

    // Abstract methods
    public abstract void withdrawal(double amount);
    public abstract void deposit(double amount);

    // Concrete method
    public void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHoldersName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Address: " + address);
        System.out.println("Current Balance: Rs. " + balance);
    }
}

// Subclass SavingsAccount
class SavingsAccount extends Accounts {
    private double rateOfInterest;

    public SavingsAccount(double balance, long accountNumber, String accountHoldersName, String address, double rateOfInterest) {
        super(balance, accountNumber, accountHoldersName, address);
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: Rs. " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance!");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to calculate interest amount for a given number of years
    public void calculateAmount(int years) {
        double interest = (balance * rateOfInterest * years) / 100;
        double totalAmount = balance + interest;
        System.out.println("Interest for " + years + " year(s) at " + rateOfInterest + "%: Rs. " + interest);
        System.out.println("Total Amount after interest: Rs. " + totalAmount);
    }
}

// Driver Class
public class BankApp {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(100000.0, 99638524, "Jasleen Kaur Bohra", "Kolkata, India", 7.5);
        
        savings.display();
        savings.deposit(10000.0);
        savings.withdrawal(5000.0);
        savings.calculateAmount(2);
        savings.display();
    }
}