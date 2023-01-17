package ru.job4j.chapter03.factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Factorial2Test {
    @Test
    public void testIsZeroOrOne() {
        Factorial2 factorial2 = new Factorial2();
        assertTrue(factorial2.isZeroOrOne(0));
        assertTrue(factorial2.isZeroOrOne(1));
        assertFalse(factorial2.isZeroOrOne(6));
    }

    @Test
    public void testFactorial() {
        Factorial2 factorial2 = new Factorial2();
        assertEquals(720, factorial2.getFactorial(6));
    }
}