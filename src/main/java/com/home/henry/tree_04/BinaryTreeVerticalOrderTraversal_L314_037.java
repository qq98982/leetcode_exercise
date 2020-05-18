package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 314. Binary Tree Vertical Order Traversal
 *
 * Given a binary tree, return the  vertical order  traversal of its nodes' values.
 * (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Input: [3,9,20,null,null,15,7]
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 * Output: [ [9], [3,15], [20], [7] ]
 *
 * Input: [3,9,8,4,0,1,7]
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 * Output: [ [4], [9], [3,0,1], [8], [7] ]
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 * Output: [ [4], [9,5], [3,0,1], [8,2], [7] ]
 */
public class BinaryTreeVerticalOrderTraversal_L314_037 {

    static class Solution {
        private int min = 0, max = 0;

        public List<List<Integer>> btVerticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            helper(root, 0);
            for (int i = min; i <= max; i++) {
                res.add(new ArrayList<>());
            }
            // 准备进行bfs
            Queue<TreeNode> queue = new LinkedList<>();
            // 存储的是index
            Queue<Integer> index = new LinkedList<>();
            // min本身为负值, root为-min,那么最左边的是0, 所以这里的min是一个offset的作用
            // max在前面只起了一个计数的作用
            index.offer(-min);
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                int idx = index.poll();
                res.get(idx).add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                    index.offer(idx - 1);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    index.offer(idx + 1);
                }
            }
            return res;
        }

        // 作用是找出最小和最大的index, 中间为0
        private void helper(TreeNode root, int index) {
            if (root == null) {return;}
            min = Math.min(min, index);
            max = Math.max(max, index);
            helper(root.left, index - 1);
            helper(root.right, index - 1);
        }
    }
}
