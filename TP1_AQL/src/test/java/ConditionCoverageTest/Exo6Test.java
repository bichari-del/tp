package ConditionCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.FizzBuzz;
import org.junit.jupiter.api.Test;

public class Exo6Test {

    @Test
    void testPositiveNumberCondition() {
        assertEquals("1", FizzBuzz.fizzBuzz(1)); // n > 0
    }

    @Test
    void testInvalidZero() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0)); // n == 0
    }

    @Test
    void testFizzCondition() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9)); // n divisible by 3 only
    }

    @Test
    void testBuzzCondition() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20)); // n divisible by 5 only
    }

    @Test
    void testFizzBuzzCondition() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45)); // divisible by both 3 and 5
    }

    @Test
    void testNeitherCondition() {
        assertEquals("8", FizzBuzz.fizzBuzz(8)); // not divisible by 3 or 5
    }
}

