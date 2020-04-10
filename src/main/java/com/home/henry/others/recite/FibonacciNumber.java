package com.home.henry.others.recite;

class FibonacciNumber {
    public int fib(int N) {
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