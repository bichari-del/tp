package ConditionCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.Anagram;
import org.junit.jupiter.api.Test;

public class Exo2Test {

    @Test
    void testNullS1True() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    void testNullS2True() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    void testDifferentLengthFalseCondition() {
        assertFalse(Anagram.isAnagram("abc", "ab"));
    }

    @Test
    void testMismatchCountFalseCondition() {
        assertFalse(Anagram.isAnagram("abc", "abd"));
    }

    @Test
    void testPerfectMatchTrue() {
        assertTrue(Anagram.isAnagram("abc", "cab"));
    }
}
