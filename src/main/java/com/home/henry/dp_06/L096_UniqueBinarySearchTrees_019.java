package com.home.henry.dp_06;

/**
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Input: 3 Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class L096_UniqueBinarySearchTrees_019 {
    static class Solution {
        /**
         * 这个题目是典型的dp题, 因为前一步取决于上一步
         * n = 3
         * root = 1, left : 0, right : 2   f(0) * f(2) root是1时, 左边只能为空, 右边为2,3
         * root = 2, left : 1, right : 1   f(1) * f(1) root是2时, 左边是1, 右边是3
         * root = 3, left : 2, right : 0   f(2) * f(0) root是3时, 左边没有, 右边是1,2
         * 初始化f(0)为1
         * f(n) = f(0) * f(n - 1) + f(1) * f(n - 2) + .... + f(n - 1) * f(0)
         */
        public static int numTrees(int n) {
            if (n < 1) {return Integer.MIN_VALUE;}
            if (n == 1) {return 1;}
            int[] res = new int[n + 1];
            res[0] = 1;
            // i代表从1到n的数
            for (int i = 1; i <= n; i++) {
                // j相当于从 0 到 n - 1
                for (int j = 0; j < i; j++) {
                    // 左子树 * 右子树
                    res[i] += res[j] * res[i - 1 - j];
                }
            }
            return res[n];
        }
    }

    public static void main(String[] args) {
        assert Solution.numTrees(2) == 2;
        assert Solution.numTrees(3) == 5;
        assert Solution.numTrees(5) == 42;
    }
}
