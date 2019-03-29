package com.home.henry.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * BFS
 */
public class BinaryTreeZigzagLevelOrderTraversal_L103_29 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // corner case
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {return res;}
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false; // if I need reverse the order
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            // initialize
            for (int i = 0; i < size; i++) {
                curr.add(0);
            }
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (flag) {
                    curr.set(size - 1 - i, tmp.val);
                } else {
                    curr.set(i, tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.add(curr);
            flag = !flag;
        }
        return res;
    }
}
