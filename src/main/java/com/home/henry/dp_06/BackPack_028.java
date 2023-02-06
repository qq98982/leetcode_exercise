package com.home.henry.dp_06;

/**
 * 一个背包能装m重量，有一个数组，分别代表重量，另一个数组，分别代表价值，求最大能带走的价值是多少。
 * 每个物品只能用一次
 *
 * 一维dp数组的两个for循环先后循序一定是先遍历物品，再遍历背包容量。
 */
public class BackPack_028 {
    public int backPack28(int m, int[] weights, int[] values) {
        int[] f = new int[m + 1];
        f[0] = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = m; j >= weights[i]; j--) {
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        return f[m];
    }
}
