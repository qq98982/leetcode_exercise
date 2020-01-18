package com.home.henry.array_01;

/**
 * 334. Increasing Triplet Subsequence
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Input: [1,2,3,4,5] Output: true Example 2:
 *
 * Input: [5,4,3,2,1] Output: false
 *
 * 方法很巧妙, 使用了滚动更新min1和min2的方法, 最主要的地方是加了两个数字, 当前数字比其中一个大, 比另外一个小
 *  如果比最大的还要大 那么就是需要的 按这个思路去更新容易写代码
 */
public class IncreasingTripletSubsequence_L334_030 {
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums.length < 3) {return false;}
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                if (curr > min2) {
                    return true;
                } else if (curr < min1) {
                    min1 = curr;
                } else if (curr > min1 && curr < min2) {
                    min2 = curr;
                }
            }
            return false;
        }
    }
}
