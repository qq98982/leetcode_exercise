package com.home.henry.tree_04;

/**
 * 333. Largest BST Subtree
 *
 * Given the root of a binary tree, find the largest
 * subtree , which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.
 *
 * A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:
 *
 * The left subtree values are less than the value of their parent (root) node's value.
 * The right subtree values are greater than the value of their parent (root) node's value.
 * Note: A subtree must include all of its descendants.
 *
 * Input: root = [10,5,15,1,8,null,7] Output: 3
 *
 * Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1] Output: 2
 */
public class L333_LargestBSTSubtree_070 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {return 0;}
        if (isBST(root, null, null)) {return getSize(root);}
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    public int getSize(TreeNode root) {
        if (root == null) {return 0;}
        return getSize(root.left) + getSize(root.right) + 1;
    }

    public boolean isBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {return true;}
        if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) {return false;}
        return (isBST(root.left, lower, root.val) && isBST(root.right, root.val, upper));
    }
}
