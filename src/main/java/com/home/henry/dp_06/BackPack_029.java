package com.home.henry.dp_06;

/**
 * 一个背包能装10重量，有一个数组，分别代表重量，另一个数组，分别代表价值，求最大能带走的价值是多少。
 * 每个物品都有无穷个
 */
public class BackPack_029 {
    public int backPack29(int m, int[] weights, int[] values) {
        int[] f = new int[m + 1];
        f[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (i > weights[j]) {
                    f[i] = Math.max(f[i], f[i - weights[j]] + values[j]);
                }
            }
        }
        return f[m];
    }
}
