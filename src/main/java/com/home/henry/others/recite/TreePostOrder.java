package com.home.henry.others.recite;

import java.util.Stack;

public class TreePostOrder {
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

    public static void postOrderRecur(TreeNode head) {
        if (head == null) {return;}
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.val + " ");
    }

    public static void postOrderIteration(TreeNode head) {
        if (head == null) {return;}
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            TreeNode curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) {
                s1.push(curr.left);
            }
            if (curr.right != null) {
                s1.push(curr.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val + " ");
        }
    }

}
