package com.home.henry.math_03;

/**
 * 204. Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Input: 10 Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes_L204_013 {

    static class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int res = 0;
            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    res++;
                    for (int j = 2; i * j < n; j++) {
                        notPrime[i * j] = true;
                    }
                }
            }
            return res;
        }
    }
}
