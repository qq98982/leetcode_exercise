package com.home.henry.array_01;

/**
 * 80. Remove Duplicates from Sorted Array II
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * in [1,1,1,2,2,3], out 5    in [0,0,1,1,1,1,2,3,3], out 7
 */
public class RemoveDuplicatesFromSortedArrayII_L80_003 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length <= 2) {
            return nums.length;
        }
        int count = 2;
        for(int i = 2; i < nums.length; i++) {
            if(nums[count - 2] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
