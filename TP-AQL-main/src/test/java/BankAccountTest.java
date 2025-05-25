import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.BankAccount;
class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0, 0.05); // Solde initial: 1000, taux: 5%
    }
//***************Test de la méthode withdraw()*******************
    @Test
    void deposit_positiveAmount_increasesBalance() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void deposit_zeroAmount_noChangeInBalance() {
        account.deposit(0.0);
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void deposit_negativeAmount_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    @Test
    void deposit_largeAmount_increasesBalance() {
        account.deposit(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE + 1000.0, account.getBalance());
    }
    //Test de la méthode transfer()
    @Test
    void transfer_validAmount_updatesBothAccounts() {
        BankAccount other = new BankAccount(500.0, 0.05);
        account.transfer(300.0, other);
        assertEquals(700.0, account.getBalance());
        assertEquals(800.0, other.getBalance());
    }

    @Test
    void transfer_amountGreaterThanBalance_throwsException() {
        BankAccount other = new BankAccount(500.0, 0.05);
        assertThrows(IllegalStateException.class, () -> account.transfer(1500.0, other));
    }

    @Test
    void transfer_toNullAccount_throwsException() {
        assertThrows(NullPointerException.class, () -> account.transfer(100.0, null));
    }

    @Test
    void transfer_zeroAmount_noChangeInBalances() {
        BankAccount other = new BankAccount(500.0, 0.05);
        account.transfer(0.0, other);
        assertEquals(1000.0, account.getBalance());
        assertEquals(500.0, other.getBalance());
    }

    @Test
    void transfer_negativeAmount_throwsException() {
        BankAccount other = new BankAccount(500.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.transfer(-100.0, other));
    }
    //************************Test de la méthode addInterest()*************************
    @Test
    void addInterest_positiveRate_increasesBalance() {
        account.addInterest();
        assertEquals(1050.0, account.getBalance()); // 1000 * 1.05
    }

    @Test
    void addInterest_zeroRate_noChangeInBalance() {
        BankAccount zeroInterestAccount = new BankAccount(1000.0, 0.0);
        zeroInterestAccount.addInterest();
        assertEquals(1000.0, zeroInterestAccount.getBalance());
    }

    @Test
    void addInterest_negativeRate_decreasesBalance() {
        BankAccount negativeInterestAccount = new BankAccount(1000.0, -0.01);
        negativeInterestAccount.addInterest();
        assertEquals(990.0, negativeInterestAccount.getBalance()); // 1000 * 0.99
    }

    @Test
    void addInterest_zeroBalance_remainsZero() {
        BankAccount zeroBalanceAccount = new BankAccount(0.0, 0.05);
        zeroBalanceAccount.addInterest();
        assertEquals(0.0, zeroBalanceAccount.getBalance());
    }
    //***************************************getBalance()*************************
    @Test
    void getBalance_positiveBalance_returnsCorrectValue() {
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void getBalance_zeroBalance_returnsZero() {
        BankAccount zeroBalanceAccount = new BankAccount(0.0, 0.05);
        assertEquals(0.0, zeroBalanceAccount.getBalance());
    }

    @Test
    void getBalance_negativeBalance_returnsNegativeValue() {
        BankAccount negativeBalanceAccount = new BankAccount(-500.0, 0.05);
        assertEquals(-500.0, negativeBalanceAccount.getBalance());
    }
}   