package com.home.henry.array_01;

import java.util.TreeSet;

/**
 * Maximum Size Subarray Sum Close To k
 * <p>
 * 325的类似题目, Given an array, find the maximum sum of subarray close to k but not larger than k.
 */
public class L325_1_MaximumSizeSubarraySumCloseToK_048_5 {
    public int maxSubarrayCloseToK(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        // 这里要用TreeSet<Integer>, 否则没有ceiling方法
        TreeSet<Integer> set = new TreeSet<>();
        // init很重要
        set.add(0);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // ceil是比sum - k稍微大点的数, 所以后面sum减去ceil就是最接近k的数
            Integer ceil = set.ceiling(sum - k);
            if (ceil != null) {
                res = Math.max(sum - ceil, res);
            }
            set.add(sum);
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

}
