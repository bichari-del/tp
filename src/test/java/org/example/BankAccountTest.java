package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit_ShouldIncreaseBalance_WhenAmountIsPositive() {
        BankAccount account = new BankAccount(100, 0.05);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void deposit_ShouldThrowException_WhenAmountIsNegative() {
        BankAccount account = new BankAccount(100, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
    }

    @Test
    void withdraw_ShouldDecreaseBalance_WhenAmountIsValid() {
        BankAccount account = new BankAccount(100, 0.05);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    void withdraw_ShouldThrowException_WhenAmountIsNegative() {
        BankAccount account = new BankAccount(100, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
    }

    @Test
    void withdraw_ShouldThrowException_WhenInsufficientBalance() {
        BankAccount account = new BankAccount(100, 0.05);
        assertThrows(IllegalStateException.class, () -> account.withdraw(200));
    }

    @Test
    void transfer_ShouldMoveMoneyBetweenAccounts() {
        BankAccount account1 = new BankAccount(100, 0.05);
        BankAccount account2 = new BankAccount(50, 0.05);
        account1.transfer(50, account2);
        assertEquals(50, account1.getBalance());
        assertEquals(100, account2.getBalance());
    }

    @Test
    void transfer_ShouldThrowException_WhenOtherAccountIsNull() {
        BankAccount account = new BankAccount(100, 0.05);
        assertThrows(NullPointerException.class, () -> account.transfer(50, null));
    }

    @Test
    void addInterest_ShouldIncreaseBalanceByInterestRate() {
        BankAccount account = new BankAccount(100, 0.05);
        account.addInterest();
        assertEquals(105, account.getBalance());
    }
}