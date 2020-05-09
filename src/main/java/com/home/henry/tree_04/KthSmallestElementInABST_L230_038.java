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

    /*
    再来看一种分治法的思路，由于 BST 的性质，可以快速定位出第k小的元素是在左子树还是右子树，首先计算出左子树的结点个数总和 cnt，
    如果k小于等于左子树结点总和 cnt，说明第k小的元素在左子树中，直接对左子结点调用递归即可。如果k大于 cnt+1，
    说明目标值在右子树中，对右子结点调用递归函数，注意此时的k应为 k-cnt-1，应为已经减少了 cnt+1 个结点。如果k正好等于 cnt+1，
    说明当前结点即为所求，返回当前结点值即可
     */
    static class SolutionDC {
        public int kthSmallest(TreeNode root, int k) {
            int count = count(root.left);
            if (k <= count) {
                return kthSmallest(root.left, k);
            } else if (k > count + 1) {
                return kthSmallest(root.right, k - count - 1);
            }
            return root.val;
        }

        private int count(TreeNode root) {
            if (root == null) {return 0;}
            return count(root.left) + count(root.right) + 1;
        }
    }

}
