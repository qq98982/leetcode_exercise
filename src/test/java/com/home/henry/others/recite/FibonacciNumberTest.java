package com.home.henry.others.recite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciNumberTest {

    private FibonacciNumber fibonacciNumberUnderTest;

    @BeforeEach
    void setUp() {
        fibonacciNumberUnderTest = new FibonacciNumber();
    }

    @Test
    void testFib() {
        assertEquals(0, fibonacciNumberUnderTest.fib(0));
        assertEquals(1, fibonacciNumberUnderTest.fib(1));
        assertEquals(1, fibonacciNumberUnderTest.fib(2));
        assertEquals(2, fibonacciNumberUnderTest.fib(3));
        assertEquals(3, fibonacciNumberUnderTest.fib(4));
        assertEquals(5, fibonacciNumberUnderTest.fib(5));
        assertEquals(8, fibonacciNumberUnderTest.fib(6));
        assertEquals(13, fibonacciNumberUnderTest.fib(7));
        assertEquals(55, fibonacciNumberUnderTest.fib(10));
        assertEquals(6765, fibonacciNumberUnderTest.fib(20));
        assertEquals(832040, fibonacciNumberUnderTest.fib(30));
        assertEquals(102334155, fibonacciNumberUnderTest.fib(40));
    }
}
