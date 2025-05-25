package BranchCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.QuadraticEquation;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    void testNegativeDelta() {
        assertNull(QuadraticEquation.solve(2, 1, 1)); // Δ = 1 - 8 = -7
    }

    @Test
    void testZeroDelta() {
        double[] result = QuadraticEquation.solve(4, 4, 1); // Δ = 0
        assertArrayEquals(new double[]{-0.5}, result);
    }

    @Test
    void testPositiveDelta() {
        double[] result = QuadraticEquation.solve(1, -5, 6); // Δ = 1
        assertArrayEquals(new double[]{3.0, 2.0}, result);
    }

    @Test
    void testThrowsWhenAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
    }
}
