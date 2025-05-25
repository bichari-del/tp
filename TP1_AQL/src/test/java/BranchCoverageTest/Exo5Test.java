package BranchCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.RomanNumeral;
import org.junit.jupiter.api.Test;

public class Exo5Test {

    @Test
    void testExactMatch() {
        assertEquals("V", RomanNumeral.toRoman(5));   // Match without subtraction
        assertEquals("XL", RomanNumeral.toRoman(40)); // Subtractive notation
    }

    @Test
    void testRepeatableSymbol() {
        assertEquals("XXX", RomanNumeral.toRoman(30)); // Repetition of X
    }

    @Test
    void testNonRepeatableSymbol() {
        assertEquals("D", RomanNumeral.toRoman(500)); // D should not repeat
    }

    @Test
    void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(5000));
    }
}
