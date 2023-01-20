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
 *
 * 1,2,3,4,null,null,5,null,6,null,null,7,8
 * pre: 1 2 4 6 7 8 3 5
 * in: 4 7 6 8 2 1 3 5
 * post: 7 8 6 4 2 5 3 1
 */
public class L145_BinaryTreePostorderTraversal_004 {
    public static List<Integer> postorderTraversal(TreeNode root) {
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

    // 这个方法也很好
    static class SolutionTwoStack {
        public static void postOrderIteration(TreeNode head) {
            if (head == null) {return;}
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                TreeNode curr = s1.pop();
                s2.push(curr);
                if (curr.left != null) {
                    s1.push(curr.left);
                }
                if (curr.right != null) {
                    s1.push(curr.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop());
            }
        }
    }

    /**
     * Tree post order recursive
     */
    public static List<Integer> postRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {return res;}
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, TreeNode root) {
        if (root == null) {return;}
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    /**
     * double stacks iterative
     */
    static class Solution {
        public static List<Integer> postorderTraversal(TreeNode root) {
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
