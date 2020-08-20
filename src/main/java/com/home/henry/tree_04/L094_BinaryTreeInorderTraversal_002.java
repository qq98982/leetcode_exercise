package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the in order traversal of its nodes' values.
 *      1
 *    2   3
 *  4   5
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 * (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 *
 * 下面的可以做为in order的模板
 */
public class L094_BinaryTreeInorderTraversal_002 {

    static class SolutionRecur {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(res, root);
            return res;
        }

        private void helper(List<Integer> res, TreeNode node) {
            if (null != node) {
                helper(res, node.left);
                res.add(node.val);
                helper(res, node.right);
            }
        }
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {return res;}
            TreeNode curr = root;
            Stack<TreeNode> stack = new Stack<>();
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
            return res;
        }
    }
}
