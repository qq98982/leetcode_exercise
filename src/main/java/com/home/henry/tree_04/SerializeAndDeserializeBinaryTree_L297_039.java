package com.home.henry.tree_04;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can
 * be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed
 * later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily
 * need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize
 * algorithms should be stateless.
 *
 * 这题有两种解法，分别为先序遍历的递归解法和层序遍历的非递归解法。
 *
 * 1. 对于序列化，我们从根节点开始，如果节点存在，则将值存入输出字符串流，然后分别对其左右子节点递归调用序列化函数即可。
 * 对于去序列化，我们先读入第一个字符，以此生成一个根节点，然后再对根节点的左右子节点递归调用去序列化函数即可
 *
 * 2. 需要借助queue来做，本质是BFS算法，就是BFS算法的常规套路稍作修改
 *
 */
public class SerializeAndDeserializeBinaryTree_L297_039 {

    static class Codec1 {
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

    static class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) { return ""; }
            StringBuilder sb = new StringBuilder();
            pre(sb, root);
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        private void pre(StringBuilder sb, TreeNode root) {
            if (root == null) {
                sb.append("#").append(",");
            } else {
                sb.append(root.val).append(",");
                pre(sb, root.left);
                pre(sb, root.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.equals("")) { return null; }
            List<String> nodes = Arrays.asList(data.split(","));
            Deque<String> queue = new ArrayDeque<>(nodes);
            return depre(queue);
        }

        private TreeNode depre(Deque<String> queue) {
            String curr = queue.poll();
            if (curr.equals("#")) {
                return null;
            } else {
                TreeNode root = new TreeNode(Integer.parseInt(curr));
                root.left = depre(queue);
                root.right = depre(queue);
                return root;
            }
        }
    }
}
