package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * 从上到下, 就要考虑pre order
 * 第一个用的是每次新生成的list, 所以最后不用remove
 * 第二个用pre和back tracking结合的
 */
public class L113_PathSumII_021 {

    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            helper(res, root, sum, new ArrayList<>());
            return res;
        }

        private void helper(List<List<Integer>> res, TreeNode root, int sum, List<Integer> list) {
            if (root == null) {return;}
            list.add(root.val);
            if (root.left == null && root.right == null) {
                if (sum - root.val == 0) {
                    res.add(list);
                }
            }
            helper(res, root.left, sum - root.val, new ArrayList<Integer>(list));
            helper(res, root.right, sum - root.val, new ArrayList<Integer>(list));
        }
    }

    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper2(res, root, sum, new ArrayList<Integer>());
        return res;
    }

    private void helper2(List<List<Integer>> res, TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null) {return;}
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
            }
        }
        helper2(res, root.left, sum - root.val, list);
        helper2(res, root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}
