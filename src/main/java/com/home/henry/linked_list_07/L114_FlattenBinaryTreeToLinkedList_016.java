package com.home.henry.linked_list_07;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class L114_FlattenBinaryTreeToLinkedList_016 {

    // prev can be set as field, this shoud be better
    public void flatten(TreeNode root) {
        flatten(root,null);
    }
    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root==null) return pre;
        pre=flatten(root.right,pre);
        pre=flatten(root.left,pre);
        root.right=pre;
        root.left=null;
        pre=root;
        return pre;
    }
}
