package com.home.henry.dp_06;

/**
 * 一个数组中的数字(正整数)，组成target可以有多少种方式，每个数字使用一次
 *
 * 一维dp数组的两个for循环先后循序一定是先遍历物品，再遍历背包容量。
 */
public class BackPack_026 {
    public int backPack26(int[] nums, int target) {
        if (nums.length == 0) {return 0;}
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                f[j] += f[j - nums[i]];
            }
        }
        return f[target];
    }
}
