package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 */
public class N_AryTreePostorderTraversal_L590_004 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, Node root) {
        if (null == root) {
            return;
        }
        for (Node node : root.children) {
            helper(res, node);
        }
        res.add(root.val);
    }
}
