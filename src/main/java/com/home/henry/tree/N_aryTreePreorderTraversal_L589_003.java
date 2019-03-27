package com.home.henry.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 */
public class N_aryTreePreorderTraversal_L589_003 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (null != root) {
            helper(res, root);
        }
        return res;
    }

    private void helper(List<Integer> res, Node node) {
        if (null != node) {
            res.add(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                helper(res, node.children.get(i));
            }
        }
    }

}
