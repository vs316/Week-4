package junit_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @BeforeEach
    void setUp() {
        // Initialize the BankAccount object before each test
        BankAccount account = new BankAccount(1000.0, 500.0);
    }

    @Test
    void getBalance() {
        // Create a BankAccount object
        BankAccount account = new BankAccount(1000.0, 500.0);

        // Check the initial balance
        assertEquals(1000.0, account.getBalance(), "Initial balance should be 1000.0");
    }

    @Test
    void deposit() {
        // Create a BankAccount object
        BankAccount account = new BankAccount(1000.0, 500.0);

        // Deposit an amount
        account.deposit(200.0);

        // Check the balance after deposit
        assertEquals(1200.0, account.getBalance(), "Balance should be 1200.0 after deposit");
    }

    @Test
    void withdraw() {
        // Create a BankAccount object
        BankAccount account = new BankAccount(1000.0, 500.0);

        // Withdraw an amount
        account.withdraw(300.0);

        // Check the balance after withdrawal
        assertEquals(700.0, account.getBalance(), "Balance should be 700.0 after withdrawal");
    }

    @Test
    void withdrawInsufficientFunds() {
        // Create a BankAccount object
        BankAccount account = new BankAccount(1000.0, 500.0);

        // Attempt to withdraw more than the balance
        boolean result = account.withdraw(1500.0);

        // Ensure the withdrawal fails
        assertFalse(result, "Withdrawal should fail if funds are insufficient");

        // Ensure the balance remains unchanged
        assertEquals(1000.0, account.getBalance(), "Balance should remain unchanged after failed withdrawal");
    }

    @Test
    void balanceUpdateAfterMultipleTransactions() {
        // Create a BankAccount object
        BankAccount account = new BankAccount(1000.0, 500.0);

        // Perform multiple transactions
        account.deposit(500.0);
        account.withdraw(300.0);
        account.deposit(200.0);

        // Check the final balance
        assertEquals(1400.0, account.getBalance(), "Balance should be correctly updated after multiple transactions");
    }

    @AfterEach
    void tearDown() {
        // Clean up the BankAccount object after each test
        BankAccount account = new BankAccount(1000.0, 500.0);
        account.setBalance(0.0);
        System.out.println("Account balance reset to zero.");
    }
}
