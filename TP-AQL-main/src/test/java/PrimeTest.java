import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Prime;
public class PrimeTest {

    @Test
    void testPrimeNumbers() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(13));
        assertTrue(Prime.isPrime(97));
    }

    @Test
    void testNonPrimeNumbers() {
        assertFalse(Prime.isPrime(1));   // Cas limite inférieur
        assertFalse(Prime.isPrime(0));   // Cas limite
        assertFalse(Prime.isPrime(-5));  // Classe invalide
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(100));
    }

    @Test
    void testLargePrimeNumber() {
        assertTrue(Prime.isPrime(7919));  // Grand nombre premier
    }
}
