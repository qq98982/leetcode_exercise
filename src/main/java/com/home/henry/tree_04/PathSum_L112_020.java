package com.home.henry.tree_04;

import java.util.Stack;

/**
 * 112. Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the
 * values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum_L112_020 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {return false;}
        if (root.left == null && root.right == null) {
            if (root.val == sum) {return true;}
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {return false;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.left == null && curr.right == null) {
                if (curr.val == sum) {
                    return true;
                }
            }
            if (curr.right != null) {
                stack.push(curr.right);
                curr.right.val += curr.val;
            }
            if (curr.left != null) {
                stack.push(curr.left);
                curr.left.val += curr.val;
            }
        }
        return false;
    }
}
