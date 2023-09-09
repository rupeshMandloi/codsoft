import java.util.*;

class UserAccount {
    private double balance;

    public UserAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean depositbalance(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\ndeposit balanced: $" + amount);
            return true;
        } else {
            System.out.println("\nInvalid deposit  amount.");
            return false;
        }
    }

    public boolean withdrawMonay(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nwithdraw : $" + amount);
            return true;
        } else {
            System.out.println("\nInvalid withdrawal amount.");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private UserAccount bankAccount;
    private Scanner scanner;

    public ATM(double initializeBalance) {
        bankAccount = new UserAccount(initializeBalance);
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. deposit Balance");
        System.out.println("3. withdraw Monay");
        System.out.println("4. Exit");
    }

    public void run() {
        scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositbalance();
                    break;
                case 3:
                    withdrawMonay();
                    break;
                case 4:
                    System.out.println("\nExiting... ATM ");
                    return ;
                default:
                    System.out.println("\nInvalid choice. Please select again.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {

        double balance = bankAccount.checkBalance();
        System.out.println("Your current balance is: $" + balance);

    }

    public void depositbalance() {
        System.out.print("Enter the amount to deposit balance: ");

        try {
            double amount = scanner.nextDouble();
            if (bankAccount.depositbalance(amount)) {
                System.out.println("$" + amount + " has been deposit balanced successfully.");
            } else {
                System.out.println("Invalid deposit balance .");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the input buffer
        }
    }

    public void withdrawMonay() {
        System.out.print("Enter the amount to withdraw Monay: ");

        try {
            double amount = scanner.nextDouble();
            if (bankAccount.withdrawMonay(amount)) {
                System.out.println("$" + amount + " has been withdrawal successfully.");
            } else {
                System.out.println("Insufficient funds or invalid withdrawal amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear the input buffer
        }
    }
}

class task3 {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        atm.run();
    }
}