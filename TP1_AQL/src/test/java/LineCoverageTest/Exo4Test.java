package LineCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.QuadraticEquation;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    void testTwoSolutions() {
        double[] result = QuadraticEquation.solve(1, -3, 2); // x^2 - 3x + 2 = 0 → x=1,2
        assertArrayEquals(new double[]{2.0, 1.0}, result);
    }

    @Test
    void testOneSolution() {
        double[] result = QuadraticEquation.solve(1, 2, 1); // x^2 + 2x + 1 = 0 → x=-1
        assertArrayEquals(new double[]{-1.0}, result);
    }

    @Test
    void testNoSolution() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // x^2 + 1 = 0 → Δ = -4
    }

    @Test
    void testZeroAThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }
}
