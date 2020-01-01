package com.home.henry.tree_04;

/**
 * 337. House Robber III
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that
 * "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked
 * houses were broken into on the same night.
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * dfs all the nodes of the tree, each node return two number, int[] num, num[0] is the max value while rob this node,
 * num[1] is max value while not rob this value. Current node return value only depend on its children's value.
 * 第一种 Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber III.
 * 第二个方法更容易看懂 Runtime: 592 ms, faster than 28.89%
 */
public class HouseRobberIII_L337_026 {

    public int rob(TreeNode root) {
        int[] num = helper(root);
        return Math.max(num[0], num[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {return new int[2];}
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public int robSec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(robInclude(root), robExclude(root));
    }

    private int robInclude(TreeNode root) {
        if (root == null) {return 0;}
        return robExclude(root.left) + robExclude(root.right) + root.val;
    }

    private int robExclude(TreeNode root) {
        if (root == null) {return 0;}
        return robSec(root.left) + robSec(root.right);
    }
}