package ConditionCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.Palindrome;
import org.junit.jupiter.api.Test;

public class Exo1Test {

    @Test
    public void testConditionTrue() {
        // Force la condition à être vraie (donc le if retourne false)
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    public void testConditionFalse() {
        // Force la condition à être fausse (donc pas de retour prématuré)
        assertTrue(Palindrome.isPalindrome("radar"));
    }

    @Test
    public void testEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("Ab ba"));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            Palindrome.isPalindrome(null);
        });
    }
}
