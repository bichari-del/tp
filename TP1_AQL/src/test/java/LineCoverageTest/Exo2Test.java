package LineCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.Anagram;
import org.junit.jupiter.api.Test;

public class Exo2Test {

    @Test
    void testIsAnagramTrueSimple() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    void testIsAnagramFalseDifferentLength() {
        assertFalse(Anagram.isAnagram("chien", "nich"));
    }

    @Test
    void testIsAnagramTrueWithSpacesAndCase() {
        assertTrue(Anagram.isAnagram("Chien ", "Niche"));
    }

    @Test
    void testIsAnagramNullInput() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "niche"));
    }
}
