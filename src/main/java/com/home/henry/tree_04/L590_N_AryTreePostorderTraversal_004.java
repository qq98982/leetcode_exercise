package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 */
public class L590_N_AryTreePostorderTraversal_004 {
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
