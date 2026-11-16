
interface Bank {
    void displayBankInfo();
    double getInterestRate();
}

interface Customer {
    void displayCustomerInfo();
}

class AccountHolder implements Bank, Customer {

    private String customerName;
    private int customerId;
    private String bankName;
    private String branch;
    private double interestRate;

    public AccountHolder(String customerName, int customerId,
                         String bankName, String branch,
                         double interestRate) {

        this.customerName = customerName;
        this.customerId = customerId;
        this.bankName = bankName;
        this.branch = branch;
        this.interestRate = interestRate;
    }

    @Override
    public void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branch);
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerId);
    }

    public void showAccountDetails() {
        System.out.println("--- Account & Customer Profile ---");

        displayCustomerInfo();
        displayBankInfo();

        System.out.println("Interest Rate: " + getInterestRate() + "%");
    }
}
public class MultipleInheritance {

    public static void main(String[] args) {

        AccountHolder holder = new AccountHolder(
            "Jasleen Kaur Bohra",
            3031,
            "State Bank of India",
            "Kolaghat",
            6.5
        );

        holder.showAccountDetails();
    }
}
