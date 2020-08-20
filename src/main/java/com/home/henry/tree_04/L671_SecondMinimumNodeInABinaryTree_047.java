package com.home.henry.tree_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 671. Second Minimum Node In a Binary Tree
 *
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
 *
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 *
 * If no such second minimum value exists, output -1 instead.
 *
 * Example 1:
 *
 * Input:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 *
 *
 * Example 2:
 *
 * Input:
 *     2
 *    / \
 *   2   2
 *
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 * 这道题让我们找二叉树中的第二小的结点值，并且给该二叉树做了一些限制，比如对于任意一个结点，要么其没有子结点，
 * 要么就同时有两个子结点，而且父结点值是子结点值中较小的那个，当然两个子结点值可以相等。那么直接上暴力搜索呗，
 * 根据该树的附加条件可知，根结点一定是最小的结点值first，那么我们只要找出第二小的值second即可，初始化为整型的最大值。
 * 然后对根结点调用递归函数，将first和second当作参数传进去即可。在递归函数中，如果当前结点为空，直接返回，
 * 若当前结点孩值不等于first，说明其肯定比first要大，然后我们看其是否比second小，小的话就更新second，
 * 然后对当前结点的左右子结点分别调用递归函数即可
 *
 * 第一个方法中, 不能修改second这个值, 所以用array
 * 第二个方法中, 用的有返回值的递归, 不会出现不能修改返回值的问题
 */
public class L671_SecondMinimumNodeInABinaryTree_047 {

    // 这个是用没有返回值的helper, 这样的话second一直没有更新的, 所以要用[]
    static class Solution {

        public int findSecondMinimumValue(TreeNode root) {
            if (root.left == null) {return -1;}
            int first = root.val;

            int[] second = { Integer.MAX_VALUE };
            helper(root, first, second);
            return (second[0] == first || second[0] == Integer.MAX_VALUE) ? -1 : second[0];
        }

        private void helper(TreeNode root, int first, int[] second) {
            if (root == null) {return;}
            if (root.val != first && root.val < second[0]) {
                second[0] = root.val;
            }
            helper(root.left, first, second);
            helper(root.right, first, second);
        }
    }

    /**
     * 在递归函数中，还是先判断当前结点是否为空，为空直接返回-1。然后就是看当前结点是否等于first，不等于直接返回当前结点值。
     * 如果等于，我们对其左右子结点分别调用递归函数，分别得到left和right。如果left和right其中有一个为-1了，
     * 我们取其中的较大值；如果left和right都不为-1，我们取其中的较小值返回即可
     */
    static class SolutionSec {

        public int findSecondMinimumValue(TreeNode root) {
            return helper(root, root.val);
        }

        private int helper(TreeNode root, int first) {
            if (root == null) {
                return -1;
            }
            if (root.val != first) {return root.val;}
            int left = helper(root.left, first), right = helper(root.right, first);

            return (left == -1 || right == -1) ? Math.max(left, right) : Math.min(left, right);
        }
    }

    /**
     * corner case: [2,2,2147483647]
     */
    static class SolutionQueue {
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null || root.left == null) {return -1;}
            int first = root.val, second = Integer.MAX_VALUE;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode curr = root;
            boolean change = false;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                if (curr.val != first && curr.val <= second) {
                    change = true;
                    second = curr.val;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            return (second == Integer.MAX_VALUE && !change) ? -1 : second;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(solution.findSecondMinimumValue(root));
        SolutionSec solutionSec = new SolutionSec();
        System.out.println(solutionSec.findSecondMinimumValue(root));
    }
}
