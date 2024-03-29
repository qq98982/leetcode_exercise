package com.home.henry.tree_04;

/**
 * 965. Univalued Binary Tree
 * <p>
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 * <p>
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * <p>
 * Input: [2,2,2,5,2]
 * Output: false
 */
public class L965_UnivaluedBinaryTree_016 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {return true;}
        return (root.left == null || (root.left.val == root.val && isUnivalTree(root.left))) && (
                root.right == null || (root.right.val == root.val && isUnivalTree(root.right)));
    }

}
