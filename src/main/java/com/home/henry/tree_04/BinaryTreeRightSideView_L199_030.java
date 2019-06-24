package com.home.henry.tree_04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView_L199_030 {
    /**
     * BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {return res;}
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (size == 0) {
                    res.add(tmp.val);
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return res;
    }

    /**
     * 1.Each depth of the tree only select one node.
     * 2. View depth is current size of result list.
     */
    public List<Integer> rightSideViewSec(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {return res;}
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int level) {
        if (root == null) {return;}
        if (level == res.size()) {
            res.add(root.val);
        }
        helper(res, root.right, level + 1);
        helper(res, root.left, level + 1);
    }
}
