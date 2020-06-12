package com.home.henry.array_01;

/**
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Input: [1,2,0] Output: 3    Input: [3,4,-1,1] Output: 2
 * Input: [7,8,9,11,12] Output: 1
 *
 * 这个测试用例就用1,2,0就可以看是不是代码正确, 用别的不好想
 */
public class FirstMissingPositive_L041_005 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
