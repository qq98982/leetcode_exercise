package com.home.henry.others.recite;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历非递归版本
 */
public class PreOrderTree {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> preOrderTreeIterate(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {return res;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }
}
