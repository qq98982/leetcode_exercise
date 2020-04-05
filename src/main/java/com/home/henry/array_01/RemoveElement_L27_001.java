package com.home.henry.array_01;

/**
 * 27. Remove Element
 *
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * in [1, 2, 3, 5, 3, 4] and 3, output [1, 2, 5, 4]
 * 主要思路是双指针, copy后面的值覆盖前面的, 最后返回的是不包含删除值的数据长度
 * 这里用的一个技巧是res++, 有不等于value的, i和res的index都会++, 否则只有i++
 */
public class RemoveElement_L27_001 {

    int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}