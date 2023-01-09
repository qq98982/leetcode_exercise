package com.home.henry.tool;

import java.util.LinkedList;
import java.util.Queue;

import com.home.henry.tree_04.TreeNode;

/**
 * @author Henry
 */
public final class TreeTools {

    public static String treeStr(TreeNode root) {
        if (root == null) {return "null";}
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        final StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode curr = queue.poll();
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
            sb.delete(sb.lastIndexOf("null"), sb.length());
        }
        return sb.toString();
    }

    public static TreeNode strTreeNodes(String str) {
        if (str == null || str.isEmpty() || "null".equals(str.trim())) {return null;}
        String split = " ";
        if (str.contains(",")) {
            split = ",";
        }
        final String[] strs = str.split(split);
        final Queue<TreeNode> queue = new LinkedList<>();
        final TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        for (int i = 1; i < strs.length; i++) {
            final TreeNode parent = queue.poll();
            if (!"null".equals(strs[i])) {
                final TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;
            if (i < strs.length && !"null".equals(strs[i])) {
                final TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        while (true) {
            if (p == null && q == null) {return true;}
            if (p == null || q == null) {return false;}
            if (p.val == q.val) {
                if (!isSameTree(p.left, q.left)) {return false;}
                q = q.right;
                p = p.right;
                continue;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);
        System.out.println(treeStr(root));
        final TreeNode x = strTreeNodes("1 2 3 4 null null 5 null null 7");
        System.out.println(treeStr(x));
    }
}
