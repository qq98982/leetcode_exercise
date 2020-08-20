package com.home.henry.tree_04;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [15,9,7,3,20]
 * preorder = [3,9,15,7,20]
 * Return the following binary tree:
 *
 *      3
 *     / \
 *    9  20
 *  /  \
 * 15   7
 */
public class L105_ConstructBinaryTreeFromPreorderAndInorderTraversal_056 {
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // pre start从0开始, inStart从0开始, 到inorder.length-1结束
            // pre的结束结点在这里不需要
            return helper(0, 0, inorder.length - 1, preorder, inorder);
        }

        private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
            // 退出条件
            if (preStart > preorder.length - 1 || inStart > inEnd) {return null;}
            // 根节点是pre order的第一个
            TreeNode root = new TreeNode(preorder[preStart]);
            int inIndex = 0;
            // 这里包含inEnd
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == root.val) {
                    // 找到对应的根节点在in order中的index
                    inIndex = i;
                }
            }
            // inStart -> inIndex-1 | inIndex+1 -> inEnd 分别是左边的范围和右边的范围
            // inIndex - inStart指的是左边的一团, 两个值都是一样的, 但是顺序不同
            // 比如 in 15,9,7,3 和 pre 3,9,15,7, 这个值就是inIndex - inStart
            // 从pre的角度来看, preStart + (inIndex - inStart) 再加 1 ,就是其右子树的index了
            root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
            root.right = helper(preStart + 1 + (inIndex - inStart), inIndex + 1, inEnd, preorder, inorder);
            return root;
        }
    }
}
