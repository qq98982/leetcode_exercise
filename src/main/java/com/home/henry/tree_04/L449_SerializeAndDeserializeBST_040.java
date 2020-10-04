package com.home.henry.tree_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 449. Serialize and Deserialize BST
 *
 * Serialization is converting a data structure or object into a sequence of bits so that it
 * can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You need to ensure that a binary search tree can be serialized to a string, and this
 * string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Input: root = [2,1,3] Output: [2,1,3]
 * Input: root = [] Output: []
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/177617/the-General-Solution-for-Serialize-and-Deserialize-BST-and-Serialize-and-Deserialize-BT
 */
public class L449_SerializeAndDeserializeBST_040 {

    /**
     * use upper and lower boundaries to check whether we should add null
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) { return; }
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) { return null; }
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(Queue<String> q, int lower, int upper) {
            if (q.isEmpty()) { return null; }
            String s = q.peek();
            int val = Integer.parseInt(s);
            if (val < lower || val > upper) { return null; }
            q.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(q, lower, val);
            root.right = deserialize(q, val, upper);
            return root;
        }
    }

}