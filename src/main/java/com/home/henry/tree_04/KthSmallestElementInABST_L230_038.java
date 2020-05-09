package com.home.henry.tree_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 230. Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 * 这道题给的提示是让我们用 BST 的性质来解题，最重要的性质是就是左<根<右，如果用中序遍历所有的节点就会得到一个有序数组。
 * 第一种是recursive, 第二种是iterative
 * 在iter中用模板即可.在recur中引入了list最后返回list.get(k-1).
 */
public class KthSmallestElementInABST_L230_038 {

    static class Solution {
        int k;

        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            this.k = k;
            helper(list, root);
            return list.get(k - 1);
        }

        private void helper(List<Integer> list, TreeNode root) {
            if (root == null) {return;}
            helper(list, root.left);
            list.add(root.val);
            if (list.size() == k) {
                return;
            }
            helper(list, root.right);
        }
    }

    static class SolutionIter {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {return 0;}
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            int res = 0;
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (--k == 0) {return curr.val;}
                    curr = curr.right;
                }
            }
            return res;
        }
    }

}
