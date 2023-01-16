package ru.job4j.chapter01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    @Test
    public void testListIsEmpty() {
        BinarySearch binarySearch = new BinarySearch();
        int[] myList = {6, 9};
        int[] emptyList = {};
        assertEquals(false, binarySearch.isListEmpty(myList));
        assertEquals(true, binarySearch.isListEmpty(emptyList));
    }

    @Test
    public void testGuessEqualsItem() {
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(true, binarySearch.guessEqualsItem(3, 3));
        assertEquals(false, binarySearch.guessEqualsItem(0, 4));
    }

    @Test
    public void testGuessIsLessThanItem() {
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(true, binarySearch.guessLessThanItem(2, 7));
        assertEquals(false, binarySearch.guessLessThanItem(6, 1));
    }

    @Test
    public void testGuessGreaterThanItem() {
        BinarySearch binarySearch = new BinarySearch();
        assertEquals(true, binarySearch.guessGreaterThanItem(17, 12));
        assertEquals(false, binarySearch.guessGreaterThanItem(13, 28));
    }

    @Test
    public void testGivenListAndItemReturnIndexOfItem() {
        BinarySearch binarySearch = new BinarySearch();
        int[] testList = {1, 3, 5, 7, 9};
        assertEquals(1, binarySearch.binarySearch(testList, 3));
        assertEquals(-1, binarySearch.binarySearch(testList, 77));
    }
}