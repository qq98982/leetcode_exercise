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
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) {return;}
        helper(root.left, k);
        count++;
        if (count == k) {result = root.val;}
        helper(root.right, k);
    }

    public int kthMsallestSec(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                if (++count == k) {return node.val;}
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }

}
