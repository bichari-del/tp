package LineCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.BinarySearch;
import org.junit.jupiter.api.Test;

public class Exo3Test {

    @Test
    void testElementFound() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, BinarySearch.binarySearch(arr, 3));
    }

    @Test
    void testElementNotFound() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, BinarySearch.binarySearch(arr, 6));
    }

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 3));
    }
}
