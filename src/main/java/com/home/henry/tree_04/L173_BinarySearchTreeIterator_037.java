package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 *
 *
 * Note:
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * 这道题主要就是考二叉树的中序遍历的非递归形式，需要额外定义一个栈来辅助，二叉搜索树的建树规则就是左<根<右，用中序遍历即可从小到大取出所有节点。
 * 如果用递归, dfs注意一下cast
 */
public class L173_BinarySearchTreeIterator_037 {

    static class Solution {
        public class BSTIterator {
            private Stack<TreeNode> stack = new Stack<TreeNode>();

            public BSTIterator(TreeNode root) {
                pushAll(root);
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public int next() {
                TreeNode tmpNode = stack.pop();
                pushAll(tmpNode.right);
                return tmpNode.val;
            }

            private void pushAll(TreeNode node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    static class SolutionSec {
        private Stack<TreeNode> stack;

        public SolutionSec(TreeNode root) {
            stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    break;
                }
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            TreeNode cur = node;
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        break;
                    }
                }
            }
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    static class BSTIterator {
        List<Integer> list;
        Iterator itor;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            dfs(root);
            itor = list.iterator();
        }

        private void dfs(TreeNode root) {
            if (root == null) {return;}
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return (int) itor.next();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return itor.hasNext();
        }
    }
}
