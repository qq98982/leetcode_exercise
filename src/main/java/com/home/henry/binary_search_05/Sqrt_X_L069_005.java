package com.home.henry.binary_search_05;

/**
 * 69. Sqrt(x)
 * 注意判定条件 mid + 1 > x / mid + 1
 * 在left向右前, 有可能mid + 1 已经可以返回了
 */
class Sqrt_X_L069_005 {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0, right = x;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid > x / mid) {
                right = mid;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }

}