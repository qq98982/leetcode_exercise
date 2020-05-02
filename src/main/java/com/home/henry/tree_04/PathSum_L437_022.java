package com.home.henry.tree_04;

/**
 * 437. Path Sum III
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSum_L437_022 {

    // 这个是brute force的方法
    static class Solution {
        public static int pathSum(TreeNode root, int sum) {
            if (root == null) {return 0;}
            return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        // dfs的意思是以其node为开始节点计算
        private static int dfs(TreeNode node, int sum) {
            if (node == null) { return 0; }
            return (node.val == sum ? 1 : 0)
                   + dfs(node.left, sum - node.val) + dfs(node.right, sum - node.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        int num = Solution.pathSum(root, 8);
        System.out.println("3 -> " + num);
    }

}
