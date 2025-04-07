package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciShouldReturn0ForNEqual0() {
        assertEquals(0, Fibonacci.fibonacci(0));
    }

    @Test
    void fibonacciShouldReturn1ForNEqual1() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void fibonacciShouldReturnCorrectValueForNEqual5() {
        assertEquals(5, Fibonacci.fibonacci(5));
    }

    @Test
    void fibonacciShouldReturnCorrectValueForNEqual10() {
        assertEquals(55, Fibonacci.fibonacci(10));
    }

    @Test
    void fibonacciShouldThrowExceptionForNegativeN() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }
}
