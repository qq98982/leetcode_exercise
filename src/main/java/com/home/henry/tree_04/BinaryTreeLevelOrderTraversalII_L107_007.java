package com.home.henry.tree_04;

import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversalII_L107_007 {

    // BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(0, new LinkedList<>());
        }
        helper(res,root.left, level + 1);
        helper(res,root.right, level + 1);
        res.get(res.size() - level - 1).add(root.val);
    }
}
