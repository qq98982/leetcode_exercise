package com.home.henry.tree;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Lowest Common Ancestor of a Binary Search Tree
 * Just walk down from the whole tree's root as long as both p and q are in the same subtree
 * (meaning their values are both smaller or both larger than root's).
 * This walks straight from the root to the LCA, not looking at the rest of the tree, so it's pretty much as fast as it gets.
 */
public class LowestCommonAncestorOfABinarySearchTree_L235_033 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }

    public TreeNode lowestCommonAncestorSec(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val - p.val) * (root.val - q.val) < 1 ? root :
               lowestCommonAncestorSec(p.val < root.val ? root.left : root.right, p, q);
    }

}
