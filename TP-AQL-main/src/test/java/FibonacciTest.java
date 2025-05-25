import org.example.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    // Tests pour les cas valides
    @Test
    void testFibonacci_Zero() {
        assertEquals(0, Fibonacci.fibonacci(0), "fibonacci(0) = 0.");
    }

    @Test
    void testFibonacci_One() {
        assertEquals(1, Fibonacci.fibonacci(1), "fibonacci(1) =1.");
    }

    @Test
    void testFibonacci_Two() {
        assertEquals(1, Fibonacci.fibonacci(2), "fibonacci(2) = 1.");
    }

    @Test
    void testFibonacci_Five() {
        assertEquals(5, Fibonacci.fibonacci(5), "fibonacci(5) = 5.");
    }

    @Test
    void testFibonacci_Ten() {
        assertEquals(55, Fibonacci.fibonacci(10), "fibonacci(10) = 55.");
    }

    // Tests pour les cas invalides
    @Test
    void testFibonacci_NegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1),
                "fibonacci(-1) doit lever une IllegalArgumentException.");
    }

    @Test
    void testFibonacci_LargeValue() {
        assertEquals(832040, Fibonacci.fibonacci(30), "fibonacci(30) doit retourner 832040.");
    }
}
