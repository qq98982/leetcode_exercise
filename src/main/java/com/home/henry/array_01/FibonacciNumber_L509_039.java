package com.home.henry.array_01;

/**
 * 509. Fibonacci Number
 */
public class FibonacciNumber_L509_039 {
    static class Solution {
        public int fib(int N) {
            if (N == 0 || N == 1) {return N;}
            int one = 0, two = 1, sum = one + two;
            for (int i = 3; i <= N; i++) {
                one = two;
                two = sum;
                sum = two + one;
            }
            return sum;
        }
    }

}
