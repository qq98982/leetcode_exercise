package com.home.henry.tree_04;

/**
 * 968. Binary Tree Cameras
 *
 * Given a binary tree, we install cameras on the nodes of the tree.
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * Input: [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 *
 * Input: [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree.
 * The above image shows one of the valid configurations of camera placement.
 *
 * Note:
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 *
 * ##########################################
 *
 * Apply a recursion function dfs.
 * Return 0 if it's a leaf.
 * Return 1 if it's a parent of a leaf, with a camera on this node.
 * Return 2 if it's covered, without a camera on this node.
 *
 * For each node,
 * if it has a child, which is leaf (node 0), then it needs camera.
 * if it has a child, which is the parent of a leaf (node 1), then it's covered.
 *
 * If it needs camera, then res++ and we return 1.
 * If it's covered, we return 2.
 * Otherwise, we return 0.
 *
 * 用的是post order的方法
 */
public class BinaryTreeCameras_L968_027 {

    static class Solution {

        private int res = 0;

        public int minCameraCover(TreeNode root) {
            return (helper(root) < 1 ? 1 : 0) + res;
        }

        private int helper(TreeNode root) {
            if (root == null) {return 2;}
            int left = helper(root.left);
            int right = helper(root.right);
            if (left == 0 || right == 0) {
                res++;
                return 1;
            }
            return (left == 1 || right == 1) ? 2 : 0;
        }

    }

}
