package com.home.henry.array_01;

/**
 * 334. Increasing Triplet Subsequence
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Input: [1,2,3,4,5] Output: true
 *
 * Input: [5,4,3,2,1] Output: false
 *
 * 方法很巧妙, 加了两个数字, 如果比2个数字还要大 那么就是需要的 按这个思路去更新容易写代码
 */
public class L334_IncreasingTripletSubsequence_030 {

    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {return false;}
            int small = Integer.MAX_VALUE;
            int big = Integer.MAX_VALUE;
            for (int curr : nums) {
                if (curr <= small) {
                    small = curr;
                } else if (curr <= big) {
                    big = curr;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
