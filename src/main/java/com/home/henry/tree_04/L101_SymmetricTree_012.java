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
public class L101_SymmetricTree_012 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {return true;}
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {return true;}
        if (p == null || q == null) {return false;}
        if (p.val != q.val) {return false;}
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

    /**
     * single stack
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {return true;}
        Stack<TreeNode> p = new Stack<>();
        p.push(root.left);
        p.push(root.right);
        while (!p.isEmpty()) {
            TreeNode n1 = p.pop();
            TreeNode n2 = p.pop();
            if (n2 == null && n1 == null) {continue;}
            if (n1 == null || n2 == null) {return false;}
            if (n2.val != n1.val) {return false;}
            p.push(n1.left);
            p.push(n2.right);
            p.push(n1.right);
            p.push(n2.left);
        }
        return true;
    }
}
