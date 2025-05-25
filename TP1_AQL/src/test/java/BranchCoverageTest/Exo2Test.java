package BranchCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.Anagram;
import org.junit.jupiter.api.Test;

public class Exo2Test {

    @Test
    void testBothNullThrows() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    @Test
    void testOnlyOneNullThrows() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    void testNotSameLength() {
        assertFalse(Anagram.isAnagram("abc", "abcd"));
    }

    @Test
    void testSameLengthButNotAnagram() {
        assertFalse(Anagram.isAnagram("abc", "abd"));
    }

    @Test
    void testValidAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }
}
