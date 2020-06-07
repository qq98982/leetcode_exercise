package com.home.henry.tool;

import java.util.LinkedList;
import java.util.Queue;

import com.home.henry.tree_04.TreeNode;

public class TreeTools {

    public static String treeStr(TreeNode root) {
        if (root == null) {return "null";}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    sb.append(curr.val + " ");
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else {
                    sb.append("null ");
                }
            }
        }
        while (sb.toString().trim().endsWith("null")) {
            sb = sb.delete(sb.lastIndexOf("null"), sb.length());
        }
        return sb.toString();
    }

    public static TreeNode strTreeNodes(String str) {
        if (str == null || str.isEmpty() || str.trim().equals("null")) {return null;}
        String[] strs = str.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        for (int i = 1; i < strs.length; i++) {
            TreeNode parent = queue.poll();
            if (!strs[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;
            if (i < strs.length && !strs[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);
        System.out.println(treeStr(root));
        TreeNode x = strTreeNodes("1 2 3 4 null null 5 null null 7");
        System.out.println(treeStr(x));
    }
}
