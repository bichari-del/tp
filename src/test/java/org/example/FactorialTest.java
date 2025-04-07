package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorial_ShouldReturn1_WhenInputIs0() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void factorial_ShouldReturnCorrectResult_WhenInputIsPositive() {
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void factorial_ShouldThrowException_WhenInputIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
}