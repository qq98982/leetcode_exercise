package com.home.henry.tree_04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 872. Leaf-Similar Trees
 *
 * Consider all the leaves of a binary tree, from left to right order,
 * the values of those leaves form a leaf value sequence.
 *
 * 后面这种方法很好，不需要走完全树
 */
public class L872_Leaf_SimilarTrees_009 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {return true;}
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        helper(root1, list1);
        helper(root2, list2);
        if (list1.size() != list2.size()) {return false;}
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode t1, List<Integer> list) {
        if (t1 == null) {return;}
        if (t1.left == null && t1.right == null) {
            list.add(t1.val);
        }
        helper(t1.left, list);
        helper(t1.right, list);
    }

    public static class Solution {
        public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LeafIterator it1 = new LeafIterator(root1);
            LeafIterator it2 = new LeafIterator(root2);
            // 逐一对比叶子节点
            while (it1.hasNext() && it2.hasNext()) {
                if (it1.next().val != it2.next().val) {
                    return false;
                }
            }
            // 最后应该都完成遍历
            return !it1.hasNext() && !it2.hasNext();
        }
    }

    // 一个生成二叉树叶子节点的迭代器
    static class LeafIterator implements Iterator {
        // 模拟递归过程
        private Stack<TreeNode> stack = new Stack<>();

        public LeafIterator(TreeNode root) {
            stack.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (cur.left == null && cur.right == null) {
                    // 发现一个叶子结点
                    return cur;
                }
                // 先入栈 root.right
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
            return null;
        }
    }
}
