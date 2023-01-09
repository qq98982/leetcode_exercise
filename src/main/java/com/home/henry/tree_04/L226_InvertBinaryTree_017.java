package com.home.henry.tree_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class L226_InvertBinaryTree_017 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return root;}
        final TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    /**
     * 使用recursive
     */
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) {return null;}
        final TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree3(root.left);
        invertTree3(root.right);
        return root;
    }

    /**
     * 使用queue，在这个过程中invert
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {return null;}
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final TreeNode curr = queue.poll();
            final TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
            if (curr.left != null) {queue.offer(curr.left);}
            if (curr.right != null) {queue.offer(curr.right);}
        }
        return root;
    }
}
