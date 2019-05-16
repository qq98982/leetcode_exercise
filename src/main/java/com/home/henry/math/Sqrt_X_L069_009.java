package com.home.henry.math;

/**
 * 69. Sqrt(x)
 */
public class Sqrt_X_L069_009 {
    static class Solution {
        public int mySqrt(int x) {
            if (x < 2) {return x;}
            int left = 0, right = x;
            while (left < right) {
                int mid = (right - left ) / 2 + left;
                if (mid > x / mid) {
                    right = mid;
                } else {
                    if ((mid + 1) > x / (mid + 1)) {
                        return mid;
                    } else  {
                        left = mid + 1;
                    }
                }
            }
            return 0;
        }
    }
}