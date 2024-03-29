package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 589. N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 */
public class L589_N_aryTreePreorderTraversal_003 {

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

    /**
     * 使用iterator
     */
    public List<Integer> preorderIterator(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {return res;}
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
