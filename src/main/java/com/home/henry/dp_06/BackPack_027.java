package com.home.henry.dp_06;

/**
 * 一个数组中的数字(正整数)，组成target可以有多少种方式，每个数字可以用多次。
 */
public class BackPack_027 {
    public int backPack27(int[] nums, int target) {
        if (nums.length == 0) {return 0;}
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    f[i] += f[i - nums[j]];
                }
            }
        }
        return f[target];
    }
}
