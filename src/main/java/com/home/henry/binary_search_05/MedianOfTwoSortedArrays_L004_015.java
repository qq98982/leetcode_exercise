package com.home.henry.binary_search_05;

/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1: nums1 = [1, 3] nums2 = [2] The median is 2.0
 * Example 2: nums1 = [1, 2] nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
 * 这个题目比较重要, 也比较难, 要求熟练掌握
 */
public class MedianOfTwoSortedArrays_L004_015 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        // 将长度小的数组放到前面处理
        if (N1 > N2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // hi是第一个数组的两倍长度
        int lo = 0, hi = N1 * 2;
        while (lo <= hi) {
            // mid1初始为2倍长度的一半, hi的一半, 也就是第一个数组的长度, 最长为N1的2倍
            int mid1 = (lo + hi) / 2;
            // mid2的初始长度为第二个数组的长度, 最长为N1 + N2 (<= 2N2)
            int mid2 = N1 + N2 - mid1;
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];
            // 如果 第二个数组的左边最靠近中间> 第一个数组右边最靠近中间, 第一个数组的中间值向右移动
            if ((L2 > R1)) {
                lo = mid1 + 1;
            } else if (L1 > R2) {
                // 如果 第一个数组的左边最靠近中间> 第二个数组右边最靠近中间, 第一个数组的中间值向左移动
                hi = mid1 - 1;
            } else {
                // 符合条件, 选取左边最大, 右边最小, 然后除2
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        return -1;
    }

}
