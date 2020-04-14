package com.home.henry.others.recite;

import java.util.Stack;

public class TreePreOrder {
    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            val = value;
            left = null;
            right = null;
        }
    }

    public void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void preOrderIteration(TreeNode head) {
        if (head == null) {return;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr.val + " ");
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }
}
