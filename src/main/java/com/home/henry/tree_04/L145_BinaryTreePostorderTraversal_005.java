package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class L145_BinaryTreePostorderTraversal_005 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return res;
    }

    /**
     * Tree post order recursive
     */
    public List<Integer> postRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {return res;}
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {return;}
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    /**
     * double stacks iterative
     */
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {return res;}
            Stack<Integer> visited = new Stack<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            visited.push(0);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                int vst = visited.pop();
                if (vst == 1) {
                    res.add(curr.val);
                } else {
                    stack.push(curr);
                    visited.push(1);
                    if (curr.right != null) {
                        stack.push(curr.right);
                        visited.push(0);
                    }
                    if (curr.left != null) {
                        stack.push(curr.left);
                        visited.push(0);
                    }
                }
            }
            return res;
        }
    }
}
