package com.home.henry.tree_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    /**
     * BST的特点是节点的左小于当前值, 右边的节点的值大于当前值
     *      5
     *    4   6
     *  1       8
     * 举例可以用先序的5 4 1 6 8代表
     */
    static class Solution {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {return "";}
            StringBuilder stringBuilder = new StringBuilder();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            // 先序遍历, 空值在这里取掉, 只保存现有节点
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                stringBuilder.append(curr.val + " ");
                if (curr.right != null) { stack.push(curr.right);}
                if (curr.left != null) {stack.push(curr.left);}
            }
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "") {return null;}
            String[] str = data.split(" ");
            Queue<Integer> queue = new LinkedList<>();
            // 将所有的元素加入到当前的queue中
            for (String s : str) {
                queue.offer(Integer.parseInt(s));
            }
            // 得到最终结果
            return getNode(queue);
        }

        private TreeNode getNode(Queue<Integer> queue) {
            if (queue.isEmpty()) { return null;}
            // 将根节点分离出来
            TreeNode root = new TreeNode(queue.poll());
            Queue<Integer> smallQueue = new LinkedList<>();
            // 如果是小于root节点, 加入到small queue中, 其他的就是大于root的就留在了正常queue中
            while (!queue.isEmpty() && queue.peek() < root.val) {
                smallQueue.offer(queue.poll());
            }
            // root的左节点就是递归调用, 将small queue中的加入进去
            root.left = getNode(smallQueue);
            // root的右节点也是递归调用, 作用到比root大的值所在的queue
            root.right = getNode(queue);
            // 最后返回root完成
            return root;
        }
    }
}