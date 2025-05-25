package BranchCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.Palindrome;
import org.junit.jupiter.api.Test;

public class Exo1Test {

    @Test
    public void testPalindromeTrueBranch() {
        assertTrue(Palindrome.isPalindrome("AMA"));
    }

    @Test
    public void testPalindromeFalseBranch() {
        assertFalse(Palindrome.isPalindrome("test"));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("A"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            Palindrome.isPalindrome(null);
        });
    }
}
