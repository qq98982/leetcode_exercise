package com.home.henry.tree_04;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
 * p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4 Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 *
 * Just walk down from the whole tree's root as long as both p and q are in the same subtree
 * (meaning their values are both smaller or both larger than root's).
 * This walks straight from the root to the LCA, not looking at the rest of the tree, so it's pretty much as fast as it gets.
 */
public class L235_LowestCommonAncestorOfABinarySearchTree_033 {

    // iter
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // multiple > 0 means it is same direction, or else split from root
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }

    // recur
    public TreeNode lowestCommonAncestorSec(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
