import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {
            System.out.println("----------------------");
            account.displayAccountDetails();
        }
    }
    public boolean accountExists(int accountNumber) {
    return findAccount(accountNumber) != null;
}
}