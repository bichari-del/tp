package ConditionCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.QuadraticEquation;
import org.junit.jupiter.api.Test;

public class Exo4Test {

    @Test
    void testConditionDeltaLessThanZero() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // Δ = -4
    }

    @Test
    void testConditionDeltaEqualsZero() {
        double[] result = QuadraticEquation.solve(1, 2, 1); // Δ = 0
        assertArrayEquals(new double[]{-1.0}, result);
    }

    @Test
    void testConditionDeltaGreaterThanZero() {
        double[] result = QuadraticEquation.solve(1, -1, -6); // Δ = 25
        assertArrayEquals(new double[]{3.0, -2.0}, result);
    }

    @Test
    void testIllegalArgumentWhenAZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 4, 4));
    }
}
