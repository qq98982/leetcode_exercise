package com.home.henry.tree;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 */
public class BinarySearchTreeIterator_L173_037 {

    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator_L173_037(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                break;
            }
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    /**
     * 还有第二种方法更容易理解一些  O(h) memory, hasNext() in O(1) time, next() is O(h) time.
     */
//
//    private Stack<TreeNode> stack = new Stack<TreeNode>();
//
//    public BSTIterator(TreeNode root) {
//        pushAll(root);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        TreeNode tmpNode = stack.pop();
//        pushAll(tmpNode.right);
//        return tmpNode.val;
//    }
//
//    private void pushAll(TreeNode node) {
//        for (; node != null; stack.push(node), node = node.left);
//    }

}
