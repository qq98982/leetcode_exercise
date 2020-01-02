package com.home.henry.tree_04;

import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 * 第一种是recursive, 第二种是iterative
 */
public class KthSmallestElementInABST_L230_038 {

    int count = 0;
    int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (--count == 0) {
            result = root.val;
        }
        helper(root.right);
    }

    public int kthSmallestSec(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (++count == k) {
                return root.val;
            }
            root = root.right;
        }
        return Integer.MIN_VALUE;
    }

}
