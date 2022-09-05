package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 590. N-ary Tree Postorder Traversal
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 */
public class L590_N_AryTreePostorderTraversal_005 {
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

    public List<Integer> postorderIter(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {return res;}
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            res.add(0, curr.val);
            for (int i = 0; i < curr.children.size(); i++) {
                stack.push(curr.children.get(i));
            }
        }
        return res;
    }
}
