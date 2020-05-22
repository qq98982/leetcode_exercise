package com.home.henry.others.zcy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 建立一个max tree
 *
 * 数组的MaxTree:
 * 1. 数组没有重复元素
 * 2. MaxTree是一棵二叉树, 数组的每一个值对应一个二叉树节点
 * 3. 包括MaxTree树在内且在其中的每一棵子树上, 值最大的节点都是树的头
 * 给定一个没有重复元素的数组,写出生成这个数组的MaxTree,要求时间O(N), 空间O(N)
 */
public class MaxTree {
    public static TreeNode getMaxTree(int[] arr) {
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
        // 每一个节点的父, 左右两边离它最近, 以比它大的数中较小的那个
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            // 单调栈
            // 如果栈顶的值小于当前值, 释放, 比如7,5, 加入6, parents中加入(5,6),stack中(7,6)
            while (!stack.isEmpty() && stack.peek().val < nodes[i].val) {
                parents.put(stack.pop(),
                            (stack.isEmpty() || nodes[i].val < stack.peek().val) ? nodes[i] : stack.peek());
            }
            // stack从(7,5)->(7,6)
            stack.push(nodes[i]);
        }
        while (!stack.isEmpty()) {
            // parents.put (6,7), (7,null)
            parents.put(stack.pop(), stack.isEmpty() ? null : stack.peek());
        }
        TreeNode head = null;
        TreeNode parent = null;
        for (int i = 0; i != arr.length; i++) {
            parent = parents.get(nodes[i]);
            if (parent == null) {
                head = nodes[i];
            } else if (parent.left == null) {
                parent.left = nodes[i];
            } else {
                parent.right = nodes[i];
            }
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode maxTree = getMaxTree(new int[] { 7, 5, 6, 4, 8, 3, 9, 1 });
        System.out.println(maxTree);
    }
}
