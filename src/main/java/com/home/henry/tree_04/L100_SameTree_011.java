package com.home.henry.tree_04;

public class L100_SameTree_011 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {return true;}
        if (p == null || q == null) {return false;}
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
