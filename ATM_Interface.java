 import java.util.Scanner;
public class ATM_Interface {

    private static final int PIN = 1234;
    private static double balance = 10000;

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        // Prompt the user for their PIN.
        System.out.println("Enter your PIN:");
        int pin = scanner.nextInt();

        // Verify the PIN.
        if (pin != PIN) {
            System.out.println("Invalid PIN.");
            System.exit(1);
        }

             String c;
c= scanner.nextLine();
        // Perform the selected operation.
        do {
            // Display the ATM menu.
            System.out.println("Choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Exit");

            // Get the user's choice.
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }


            System.out.println("Do you want to continue?:");
            c=scanner.next();
        }while(c!="n"||c!="N");

    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Your new balance is: " + balance);
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();

        balance += amount;

        System.out.println("Deposit successful.");
        System.out.println("Your new balance is: " + balance);
    }

    private static void transfer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the account number to transfer to:");
        String accountNumber = scanner.next();

        System.out.println("Enter the amount to transfer:");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance-=amount;
        System.out.println("Transferred successfully!\nYour current balance:"+balance);
    }
}
