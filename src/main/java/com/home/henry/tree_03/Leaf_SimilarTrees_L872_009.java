package com.home.henry.tree_03;

public class Leaf_SimilarTrees_L872_009 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        String res1 = traverse(root1, r1);
        String res2 = traverse(root2, r2);
        return res1.equals(res2);
    }

    private String traverse(TreeNode root, StringBuilder r) {
        if (root == null) { return ""; }
        if (root.left == null && root.right == null) {
            r.append(root.val).append("-");
        }
        traverse(root.left, r);
        traverse(root.right, r);
        return r.toString();
    }
}
