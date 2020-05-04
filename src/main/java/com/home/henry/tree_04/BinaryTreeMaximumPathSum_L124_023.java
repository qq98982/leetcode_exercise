package com.home.henry.tree_04;

/**
 * 124. Binary Tree Maximum Path Sum
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
 *
 * 涉及到tree中的拆线, 大部分为post order方法, 这个就是这样的
 */
public class BinaryTreeMaximumPathSum_L124_023 {

    static class Solution {
        int res;

        public int maxPathSum(TreeNode root) {
            res = Integer.MIN_VALUE;
            helper(root);
            return res;
        }

        private int helper(TreeNode root) {
            if (root == null) {return 0;}
            int left = Math.max(0, helper(root.left));
            int right = Math.max(0, helper(root.right));
            res = Math.max(res, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }

}
