package BranchCoverageTest;


import static org.junit.jupiter.api.Assertions.*;

import org.example.BinarySearch;
import org.junit.jupiter.api.Test;

public class Exo3Test {

    @Test
    void testElementFoundAtBeginning() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(0, BinarySearch.binarySearch(arr, 10));
    }

    @Test
    void testElementFoundAtEnd() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(4, BinarySearch.binarySearch(arr, 50));
    }

    @Test
    void testElementNotFoundMiddle() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(-1, BinarySearch.binarySearch(arr, 35));
    }

    @Test
    void testElementFoundSingleElement() {
        int[] arr = {42};
        assertEquals(0, BinarySearch.binarySearch(arr, 42));
    }

    @Test
    void testElementNotFoundSingleElement() {
        int[] arr = {42};
        assertEquals(-1, BinarySearch.binarySearch(arr, 43));
    }
}
