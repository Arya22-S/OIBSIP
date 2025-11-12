import java.util.*;

class BankAccount {
    private String userName;
    private String userId;
    private String userPin;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String userName, String userId, String userPin) {
        this.userName = userName;
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean validatePin(String enteredPin) {
        return this.userPin.equals(enteredPin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            recipient.balance += amount;
            transactionHistory.add("Transferred: ₹" + amount + " to " + recipient.userName);
            System.out.println("₹" + amount + " transferred successfully to " + recipient.userName);
        } else {
            System.out.println("Transfer failed. Check balance or amount.");
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\nTransaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount user = new BankAccount("Arya", "user123", "1234");
        BankAccount receiver = new BankAccount("Rohan", "user456", "4321");

        System.out.println("===== Welcome to ATM System =====");
        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (enteredId.equals("user123") && user.validatePin(enteredPin)) {
            System.out.println("\nLogin successful!\n");

            int choice;
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        user.showTransactionHistory();
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawAmount = sc.nextDouble();
                        user.withdraw(withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = sc.nextDouble();
                        user.deposit(depositAmount);
                        break;

                    case 4:
                        System.out.print("Enter amount to transfer: ₹");
                        double transferAmount = sc.nextDouble();
                        user.transfer(receiver, transferAmount);
                        break;

                    case 5:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 5);

        } else {
            System.out.println("Invalid User ID or PIN!");
        }

        sc.close();
    }
}
