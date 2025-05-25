import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Factorial;
public class FactorialTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0));  // Cas limite
    }

    @Test
    void testFactorialOfPositiveNumbers() {
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void testFactorialOfNegativeNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));  // Classe invalide
    }

    @Test
    void testLargeFactorial() {
        assertEquals(3628800, Factorial.factorial(10));  // 10! = 3628800
    }
}
