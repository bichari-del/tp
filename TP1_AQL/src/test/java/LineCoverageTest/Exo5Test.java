package LineCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.RomanNumeral;
import org.junit.jupiter.api.Test;

public class Exo5Test {

    @Test
    void testSingleDigits() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("III", RomanNumeral.toRoman(3));
    }

    @Test
    void testCompoundNumbers() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XIV", RomanNumeral.toRoman(14));
    }

    @Test
    void testThousands() {
        assertEquals("M", RomanNumeral.toRoman(1000));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
    }

    @Test
    void testOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
    }
}
