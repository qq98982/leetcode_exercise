package com.home.henry.binary_search_08;

/**
 * 668. Kth Smallest Number in Multiplication Table
 * Time: O(m * log(m * n)) Space: O(1)
 */
public class KthSmallestNumberInMultiplicationTable_L668_014 {

    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (countSum(m, n, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 计算出小于等于mid的数的个数, 这里要看乘法表中的规律, 降低了复杂度
    private int countSum(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, mid / i);
        }
        return count;
    }

}
