package com.home.henry.binary_search_08;

/**
 * 1539. Kth Missing Positive Number
 *
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 *
 * Input: arr = [2,3,4,7,11], k = 5 Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 *
 * Input: arr = [1,2,3,4], k = 2 Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 */
public class L1539_KthMissingPositiveNumber_020 {
    /**
     * Assume the final result is x,
     * And there are m number not missing in the range of [1, x].
     * Binary search the m in range [0, A.size()].
     *
     * If there are m number not missing,
     * that is A[0], A[1] .. A[m-1],
     * the number of missing under A[m] is A[m] - 1 - m.
     *
     * If A[m] - 1 - m < k, m is too small, we update left = m.
     * If A[m] - 1 - m >= k, m is big enough, we update right = m.
     *
     * Note that, we exit the while loop, l = r,
     * which equals to the number of missing number used.
     * So the Kth positive number will be l + k.
     */
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - 1 - mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
