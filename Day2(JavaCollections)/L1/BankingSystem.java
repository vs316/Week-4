package JavaCollections.MapInterface;

import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>(Collections.reverseOrder());
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add a new account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            double newBalance = oldBalance + amount;

            // Remove account from old balance list
            List<Integer> accountsWithOldBalance = sortedAccounts.get(oldBalance);
            accountsWithOldBalance.remove(Integer.valueOf(accountNumber));
            if (accountsWithOldBalance.isEmpty()) {
                sortedAccounts.remove(oldBalance);
            }

            // Add account to new balance list
            accounts.put(accountNumber, newBalance);
            sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
            System.out.println("Deposited " + amount + " to account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money (adds to queue)
    public void requestWithdrawal(int accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request for " + amount + " added to queue.");
    }

    // Process withdrawals
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            if (accounts.containsKey(request.accountNumber)) {
                double oldBalance = accounts.get(request.accountNumber);
                if (oldBalance >= request.amount) {
                    double newBalance = oldBalance - request.amount;

                    // Remove account from old balance list
                    List<Integer> accountsWithOldBalance = sortedAccounts.get(oldBalance);
                    accountsWithOldBalance.remove(Integer.valueOf(request.accountNumber));
                    if (accountsWithOldBalance.isEmpty()) {
                        sortedAccounts.remove(oldBalance);
                    }

                    // Add account to new balance list
                    accounts.put(request.accountNumber, newBalance);
                    sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(request.accountNumber);
                    System.out.println(
                            "Processed withdrawal of " + request.amount + " from account " + request.accountNumber);
                } else {
                    System.out.println("Insufficient funds in account " + request.accountNumber);
                }
            } else {
                System.out.println("Account not found: " + request.accountNumber);
            }
        }
    }

    // Display all accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance (highest to lowest):");
        sortedAccounts.forEach((balance, accountList) -> {
            accountList.forEach(accountNumber -> System.out.println("Account " + accountNumber + ": $" + balance));
        });
    }

    // Inner class for withdrawal requests
    private static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Test cases
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 3000);
        bank.addAccount(1003, 3000); // Same balance as 1002

        bank.deposit(1001, 2000);
        bank.requestWithdrawal(1001, 2500);
        bank.requestWithdrawal(1002, 500);

        System.out.println("\nInitial sorted accounts:");
        bank.displaySortedAccounts();

        System.out.println("\nProcessing withdrawals:");
        bank.processWithdrawals();

        System.out.println("\nFinal sorted accounts:");
        bank.displaySortedAccounts();
    }
}