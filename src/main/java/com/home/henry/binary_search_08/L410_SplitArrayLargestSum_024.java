package com.home.henry.binary_search_08;

/**
 * 410. Split Array Largest Sum
 *
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 *
 * Return the minimized largest sum of the split.
 *
 * A subarray is a contiguous part of the array.
 *
 * Input: nums = [7,2,5,10,8], k = 2 Output: 18
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 *
 * Input: nums = [1,2,3,4,5], k = 2 Output: 9
 * Explanation: There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 */
public class L410_SplitArrayLargestSum_024 {

    public int splitArray(int[] nums, int m) {
        int low = 0, high = 0;

        for (int n: nums) {
            low = Math.max(low, n);
            high += n;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // check if it is possbile to split to m subarrays which each subarry's sum less than or equal to mid
    private boolean check(int[] nums, int m, int mid) {
        int sum = 0;
        int numOfSubarrays = 1;

        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (sum > mid) {
                numOfSubarrays ++;
                sum = nums[i];
            }
        }

        return numOfSubarrays <= m;
    }
}
