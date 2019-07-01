package com.home.henry.array_01;

import java.util.Arrays;

/**
 * 561. Array Partition I
 * 两个数字中取小的, 并且最后加起来是最大的
 */
public class ArrayPartitionI_L561_037 {

    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }
            return res;
        }
    }

}
