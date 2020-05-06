package com.home.henry.tree_04;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
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
