package com.home.henry.tree_04;

import java.util.Stack;

/**
 * 101. Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
public class SymmetricTree_L101_012 {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {return true;}
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode p, TreeNode q) {
            if (p == null && q == null) {return true;}
            if (p == null || q == null) {return false;}
            return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
    }

    static class Solution2 {
        public boolean isSymetric(TreeNode root) {
            if (root == null) {return true;}
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root.left);
            stack.push(root.right);
            while (!stack.isEmpty()) {
                TreeNode n1 = stack.pop();
                TreeNode n2 = stack.pop();
                if (n1 == null && n2 == null) {continue;}
                if (n1 == null || n2 == null || n1.val != n2.val) {return false;}
                stack.push(n1.left);
                stack.push(n2.right);
                stack.push(n1.right);
                stack.push(n2.left);
            }
            return true;
        }
    }
}
