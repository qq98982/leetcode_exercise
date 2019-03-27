package com.home.henry.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the pre order traversal of its nodes' values.
 *  *      1
 *  *    2   3
 *  *  4   5
 *  * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 *  * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 *  * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class BinaryTreePreorderTraversal_L144_001 {

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

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
            if (node == null && !stack.isEmpty()) {
                node = stack.pop();
            }
        }
        return res;
    }

}
