package com.home.henry.tree_04;

import java.util.Stack;

/**
 * 99. Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 */
public class RecoverBinarySearchTree_L099_040 {

    /**
     * 第一种做法用的是iterator, 使用了in order的模板
     */
    static class Solution {
        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode first = null;
            TreeNode second = null;
            TreeNode prev = null;
            TreeNode curr = root;
            Stack<TreeNode> stack = new Stack<>();
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (prev != null && curr.val < prev.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    /**
     * 方法2用的是递归
     */
    static class Solution2 {

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }
            helper(root);
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        private void helper(TreeNode node) {
            if (node == null) {
                return;
            }
            helper(node.left);
            if (prev != null && prev.val >= node.val) {
                if (first == null) {
                    first = prev;
                }
                second = node;
            }
            prev = node;
            helper(node.right);
        }
    }
}
