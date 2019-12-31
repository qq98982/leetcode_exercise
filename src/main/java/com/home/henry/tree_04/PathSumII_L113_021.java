package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 * 推荐第二个用ArrayList的解法
 */
public class PathSumII_L113_021 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root, sum, new Stack<Integer>());
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int sum, Stack<Integer> history) {
        if(root == null) {return;}
        history.push(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            List<Integer> list = new ArrayList<>();
            for (int x : history) {
                list.add(x);
            }
            res.add(list);
        }
        helper(res, root.left, sum - root.val, history);
        helper(res, root.right, sum - root.val, history);
        history.pop();
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
        list.remove(list.size() -1);
    }
}
