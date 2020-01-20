package com.home.henry.array_01;

/**
 * 509. Fibonacci Number
 * 使用old, curr, now更好理解
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
        public int fib2(int N) {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 1; i <= 30; i++) {
            System.out.println(s.fib(i) == s.fib2(i));
        }
    }

}
