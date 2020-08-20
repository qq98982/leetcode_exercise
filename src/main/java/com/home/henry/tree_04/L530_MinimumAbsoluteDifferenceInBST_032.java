package com.home.henry.tree_04;

import java.util.Stack;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Input:
 *    1
 *     \
 *      3
 *     /
 *    2
 * Output: 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * test case : [236,104,701,null,227,null,911] [5,4,7] [1,null,3,2]
 *
 * 第一个方法中加入了两个共同变量, 第二个只要一个, 两个都是in order
 */
public class L530_MinimumAbsoluteDifferenceInBST_032 {

    static class Solution {
        private int minDiff = Integer.MAX_VALUE;

        private TreeNode prev;

        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minDiff;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {return;}
            inOrder(root.left);
            if (prev != null) {
                minDiff = Math.min(minDiff, root.val - prev.val);
            }
            prev = root;
            inOrder(root.right);
        }
    }

    static class SolutionThreeParam {

        int diff = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            helper(root, null, null);
            return diff;
        }

        private void helper(TreeNode root, Integer min, Integer max) {
            if (root == null) {return;}
            helper(root.left, min, root.val);
            if (min != null) {
                diff = Math.min(diff, root.val - min);
            }
            if (max != null) {
                diff = Math.min(diff, max - root.val);
            }
            helper(root.right, root.val, max);
        }
    }

    // in order 模板修改
    static class SolutionIter {
        public int getMinimumDifference(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            int res = Integer.MAX_VALUE;
            TreeNode curr = root, pre = null;
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (pre != null) {
                        res = Math.min(res, curr.val - pre.val);
                    }
                    pre = curr;
                    curr = curr.right;
                }
            }
            return res;
        }
    }

}
