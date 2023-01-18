package com.home.henry.array_01;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * in [0,0,1,1,1,2,2,3,3,4], out 5
 * 因为是sorted array, 所以index为i - 1的和前一个比较, 同样使用了++技巧, 并且注意count和index从1开始计算
 */
public class L026_RemoveDuplicatesFromSortedArray_002 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count - 1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

}
