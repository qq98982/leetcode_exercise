package com.home.henry.tree_03;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class SerializeAndDeserializeBinaryTree_L297_039 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val).append(" ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }
        String[] split = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        for (int i = 1; i < split.length; i++) {
            TreeNode parent = queue.poll();
            if (!split[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(split[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!split[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(split[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
