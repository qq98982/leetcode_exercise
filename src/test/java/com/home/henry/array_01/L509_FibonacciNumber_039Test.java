package com.home.henry.array_01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class L509_FibonacciNumber_039Test {

    @Test
    void testFib() {
        Assertions.assertEquals(0, L509_FibonacciNumber_039.Solution.fib(0));
        Assertions.assertEquals(1, L509_FibonacciNumber_039.Solution.fib(1));
        Assertions.assertEquals(1, L509_FibonacciNumber_039.Solution.fib(2));
        Assertions.assertEquals(2, L509_FibonacciNumber_039.Solution.fib(3));
        Assertions.assertEquals(3, L509_FibonacciNumber_039.Solution.fib(4));
        Assertions.assertEquals(5, L509_FibonacciNumber_039.Solution.fib(5));
        Assertions.assertEquals(8, L509_FibonacciNumber_039.Solution.fib(6));
        Assertions.assertEquals(13, L509_FibonacciNumber_039.Solution.fib(7));
        Assertions.assertEquals(6765, L509_FibonacciNumber_039.Solution.fib(20));
    }
}
