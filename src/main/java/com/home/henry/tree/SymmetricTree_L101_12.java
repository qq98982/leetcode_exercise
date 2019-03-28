package com.home.henry.tree;

public class SymmetricTree_L101_12 {
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
