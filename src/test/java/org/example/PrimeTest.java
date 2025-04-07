package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PrimeTest {

    @Test
    void isPrime_ShouldReturnFalse_WhenNumberIsLessThan2() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
    }

    @Test
    void isPrime_ShouldReturnTrue_WhenNumberIsPrime() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(7));
        assertTrue(Prime.isPrime(11));
    }

    @Test
    void isPrime_ShouldReturnFalse_WhenNumberIsNotPrime() {
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(8));
        assertFalse(Prime.isPrime(9));
        assertFalse(Prime.isPrime(10));
    }
}