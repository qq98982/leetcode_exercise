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

    private static void helper(List<Integer> res, TreeNode root) {
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
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stk.push(curr.right);
            }
            if (curr.left != null) {
                stk.push(curr.left);
            }
        }
        return res;
    }
}