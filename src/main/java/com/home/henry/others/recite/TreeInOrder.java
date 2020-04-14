package com.home.henry.others.recite;

import java.util.Stack;

public class TreeInOrder {
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

    public static void inOrder(TreeNode head) {
        if (head == null) {return;}
        inOrder(head.left);
        System.out.println(head.val + " ");
        inOrder(head.right);
    }

    public static void inOrderIteration(TreeNode head) {
        if (head == null) {return;}
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()||head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val + " ");
                head = head.right;
            }
        }
    }
}


