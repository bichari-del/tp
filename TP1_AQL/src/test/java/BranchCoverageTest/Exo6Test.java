package BranchCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.FizzBuzz;
import org.junit.jupiter.api.Test;

public class Exo6Test {

    @Test
    void testDivisibleBy3Only() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
    }

    @Test
    void testDivisibleBy5Only() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testDivisibleBy3And5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    void testNotDivisibleBy3Or5() {
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }

    @Test
    void testIllegalArgumentThrown() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
    }
}

