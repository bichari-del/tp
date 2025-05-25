package ConditionCoverageTest;



import static org.junit.jupiter.api.Assertions.*;

import org.example.BinarySearch;
import org.junit.jupiter.api.Test;

public class Exo3Test {

    @Test
    void testNullThrows() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1));
    }

    @Test
    void testLessThanCondition() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(1, BinarySearch.binarySearch(arr, 20));
    }

    @Test
    void testGreaterThanCondition() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(2, BinarySearch.binarySearch(arr, 30));
    }

    @Test
    void testEqualCondition() {
        int[] arr = {10, 20, 30, 40};
        assertEquals(0, BinarySearch.binarySearch(arr, 10));
    }

    @Test
    void testNotFound() {
        int[] arr = {1, 3, 5};
        assertEquals(-1, BinarySearch.binarySearch(arr, 2));
    }
}
