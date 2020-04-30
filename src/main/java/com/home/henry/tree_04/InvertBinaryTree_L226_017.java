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
public class InvertBinaryTree_L226_017 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return root;}
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {return root;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) { queue.offer(curr.left);}
            if (curr.right != null) { queue.offer(curr.right);}
        }
        return root;
    }
}
