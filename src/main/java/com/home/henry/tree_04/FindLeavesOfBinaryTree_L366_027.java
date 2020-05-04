package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat
 * until the tree is empty.
 *
 * Given binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Returns [4, 5, 3], [2], [1].
 *
 * post order 返回值是层数, 按层数放到list中
 */
public class FindLeavesOfBinaryTree_L366_027 {

    static class Solution {
        public static List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, root);
            return res;
        }

        private static int helper(List<List<Integer>> res, TreeNode root) {
            if (root == null) {
                return -1;
            }
            int left = helper(res, root.left);
            int right = helper(res, root.right);
            int level = Math.max(left, right) + 1;
            if (res.size() <= level) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            return level;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.print("[[4, 5, 3], [2], [1]] -> " + Solution.findLeaves(root));
    }
}
