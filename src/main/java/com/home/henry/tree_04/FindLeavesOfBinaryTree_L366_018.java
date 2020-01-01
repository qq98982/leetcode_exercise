package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesOfBinaryTree_L366_018 {

    public static class Solution {
        public List<List<Integer>> findLeavesOfBinaryTree(TreeNode node){
            List<List<Integer>> res = new ArrayList<>();
            helper(res, node);
            return res;
        }

        private int helper(List<List<Integer>> res, TreeNode node) {
            if (node == null) {return -1;}
            int left = helper(res, node.left);
            int right = helper(res, node.right);
            int curr = Math.max(left, right) + 1;
            if (curr > res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(curr).add(node.val);
            return curr;
        }
    }
}
