package LineCoverageTest;


import static org.junit.jupiter.api.Assertions.*;


import org.example.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Exo1Test {

    @Test
    public void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("alala"));
    }

    @Test
    public void testPalindromeWithSpacesAndCase() {
        assertTrue(Palindrome.isPalindrome("amine woowow"));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("TPAQLamine"));
    }

    @Test
    public void testNullInputThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            Palindrome.isPalindrome(null);
        });
    }
}
