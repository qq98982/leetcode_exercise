package com.home.henry.tree_03;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * template for in order tree: https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
public class ValidateBinarySearchTree_L98_031 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {return true;}
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {return false;}
            pre = root;
            root = root.right;
        }
        return true;
    }

    /**
     * 第二种方法看上去更容易理解
     */
    public boolean isValdiBSTSec(TreeNode root) {
        return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode root, int minValue, int maxValue) {
        if (root == null) {return true;}
        if (root.val >= maxValue || root.val <= minValue) {return false;}
        return isValidBst(root.left, minValue, root.val) && isValidBst(root.right, root.val, maxValue);
    }

}
