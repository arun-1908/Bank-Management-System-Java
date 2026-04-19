import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.print("Enter Username: ");
String username = sc.nextLine();

System.out.print("Enter Password: ");
String password = sc.nextLine();

if (!username.equals("admin") || !password.equals("1234")) {
    System.out.println("Invalid Login!");
    sc.close();
    return;
}

System.out.println("Login Successful!");

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. View All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();

                    BankAccount newAccount = new BankAccount(accNo, name, balance);
                    bank.createAccount(newAccount);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositAccNo = sc.nextInt();

                    BankAccount depositAccount = bank.findAccount(depositAccNo);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawAccNo = sc.nextInt();

                    BankAccount withdrawAccount = bank.findAccount(withdrawAccNo);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int checkAccNo = sc.nextInt();

                    BankAccount checkAccount = bank.findAccount(checkAccNo);
                    if (checkAccount != null) {
                        System.out.println("Current Balance: " + checkAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int detailsAccNo = sc.nextInt();

                    BankAccount detailsAccount = bank.findAccount(detailsAccNo);
                    if (detailsAccount != null) {
                        detailsAccount.displayAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    bank.viewAllAccounts();
                    break;

                case 7:
                    System.out.println("Thank you for using Bank Management System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}