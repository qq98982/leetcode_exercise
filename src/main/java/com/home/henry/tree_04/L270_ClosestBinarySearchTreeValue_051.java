package com.home.henry.tree_04;

/**
 * 270. Closest Binary Search Tree Value
 *
 * bst中找到和当前节点最接近的节点值
 */
public class L270_ClosestBinarySearchTreeValue_051 {
    static class Solution {
        // 利用二分搜索树的特点 (左<根<右) 来快速定位，由于根节点是中间值，在往下遍历时，根据目标值和根节点的值大小关系来比较，
        // 如果目标值小于节点值，则应该找更小的值，于是到左子树去找，反之去右子树找
        // 一句话, 如果比root大,找比root大的当中最小的,比root小,去找比root小中最大的.
        public int closedValue(TreeNode root, double target) {
            int res = root.val;
            while (root != null) {
                if (Math.abs(target - root.val) < Math.abs(target - res)) {
                    res = root.val;
                }
                root = root.val > target ? root.left : root.right;
            }
            return res;
        }

        // 递归的写法和上面迭代的方法思路相同，都是根据二分搜索树的性质来优化查找，但是递归的写法用的是回溯法，先遍历到叶节点，
        // 然后一层一层的往回走，把最小值一层一层的运回来
        public int closeValueRecur(TreeNode root, double target) {
            int a = root.val;
            TreeNode temp = target < a ? root.left : root.right;
            if (temp == null) {return a;}
            int b = closeValueRecur(temp, target);
            return Math.abs(a - target) < Math.abs(b - target) ? a : b;
        }

        // 这个要好写点
        public int closeValueRecur2(TreeNode root, double target) {
            return helper(root, target, root.val);
        }

        private int helper(TreeNode root, double target, int val) {
            if (root == null) {return val;}
            if (Math.abs(root.val - target) < Math.abs(val - target)) {
                val = root.val;
            }
            if (root.val < target) {
                val = helper(root.right, target, val);
            } else if (root.val > target) {
                val = helper(root.left, target, val);
            }
            return val;
        }
    }
}
