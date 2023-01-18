package com.home.henry.array_01;

/**
 * 509. Fibonacci Number
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1.
 *
 * Input: n = 2 Output: 1
 * Input: n = 3 Output: 2
 * Input: n = 4 Output: 3
 */
public class L509_FibonacciNumber_039 {
    public static int fib(int N) {
        if (N < 2) {return N;}
        int[] f = new int[N + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= N; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N];
    }

    public static int fib2(int N) {
        if (N <= 1) {return N;}
        int old = 1, curr = 1, now = 1;
        for (int i = 3; i <= N; i++) {
            old = curr;
            curr = now;
            now = old + curr;
        }
        return now;
    }

}
