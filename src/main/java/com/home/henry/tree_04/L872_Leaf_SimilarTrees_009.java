package com.home.henry.tree_04;

import java.util.Iterator;
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
        if (root1 == null || root2 == null) {
            return false;
        }
        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        String res1 = traverse(root1, r1);
        String res2 = traverse(root2, r2);
        return res1.equals(res2);
    }

    private String traverse(TreeNode root, StringBuilder r) {
        if (root == null) { return ""; }
        if (root.left == null && root.right == null) {
            r.append(root.val).append("-");
        }
        traverse(root.left, r);
        traverse(root.right, r);
        return r.toString();
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
        private Stack<TreeNode> stk = new Stack<>();

        public LeafIterator(TreeNode root) {
            stk.push(root);
        }

        @Override
        public boolean hasNext() {
            return !stk.isEmpty();
        }

        @Override
        public TreeNode next() {
            while (!stk.isEmpty()) {
                TreeNode cur = stk.pop();
                if (cur.left == null && cur.right == null) {
                    // 发现一个叶子结点
                    return cur;
                }
                // 先入栈 root.right
                if (cur.right != null) {
                    stk.push(cur.right);
                }
                if (cur.left != null) {
                    stk.push(cur.left);
                }
            }
            return null;
        }
    }
}
