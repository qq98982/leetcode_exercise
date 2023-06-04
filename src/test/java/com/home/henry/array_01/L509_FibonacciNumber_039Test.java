package com.home.henry.array_01;

import static com.home.henry.array_01.L509_FibonacciNumber_039.fib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L509_FibonacciNumber_039Test {

    @Test
    void testFib() {
        for (int i = 1; i < 20; i++) {
            System.out.println(fib(i) - 1);
        }
        Assertions.assertEquals(0, fib(0));
        Assertions.assertEquals(1, fib(1));
        Assertions.assertEquals(1, fib(2));
        Assertions.assertEquals(2, fib(3));
        Assertions.assertEquals(3, fib(4));
        Assertions.assertEquals(5, fib(5));
        Assertions.assertEquals(8, fib(6));
        Assertions.assertEquals(13, fib(7));
        Assertions.assertEquals(6765, fib(20));
    }
}
