package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the pre order traversal of its nodes' values.
 * *      1
 * *    2   3
 * *  4   5
 * * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class L144_BinaryTreePreorderTraversal_001 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    /**
     * iterative pre order
     */
    public List<Integer> preorderTraversalIterativeSimple(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return res;
    }
}