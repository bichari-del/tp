package ConditionCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.RomanNumeral;
import org.junit.jupiter.api.Test;

public class Exo5Test {

    @Test
    void testLowerBoundInclusive() {
        assertEquals("I", RomanNumeral.toRoman(1)); // n == 1
    }

    @Test
    void testUpperBoundInclusive() {
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999)); // n == 3999
    }

    @Test
    void testBelowLowerBound() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
    }

    @Test
    void testAboveUpperBound() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }

    @Test
    void testInsideBounds() {
        assertEquals("CXLIV", RomanNumeral.toRoman(144)); // well inside bounds
    }
}
