package com.home.henry.dfs_10_1;

import java.util.ArrayList;
import java.util.List;

import com.home.henry.tool.TreeTools;
import com.home.henry.tree_04.TreeNode;

/**
 * 95. Unique Binary Search Trees II
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees)
 * that store values 1 ... n.
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class L095_UniqueBinarySearchTreesII {
    /**
     * 分治的思想去解题, 左边和右边的分别求来, 然后再循环分别以左右子树加入到res中, 最后返回
     */
    static class Solution {
        public static List<TreeNode> generateTrees(int n) {
            return helper(1, n);
        }

        private static List<TreeNode> helper(int start, int end) {
            List<TreeNode> res = new ArrayList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSub = helper(start, i - 1);
                List<TreeNode> rightSub = helper(i + 1, end);
                for (TreeNode left : leftSub) {
                    for (TreeNode right : rightSub) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = Solution.generateTrees(3);
        assert treeNodes.size() == 5;
        for (TreeNode root : treeNodes) {
            System.out.print(TreeTools.treeStr(root) + "|| ");
        }
    }
}
