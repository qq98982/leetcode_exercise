package com.home.henry.tree_04;

/**
 * 285. Inorder Successor in BST
 *
 * 找到p的后续节点并返回
 */
public class L285_InorderSuccessorInBST_050 {
    static class Solution {

        // 利用到 BST 的性质，首先看根节点值和p节点值的大小，如果根节点值大，说明p节点肯定在左子树中，那么此时先将 res 赋为
        // root，然后 root 移到其左子节点，循环的条件是 root 存在，再比较此时 root 值和p节点值的大小，如果还是 root 值大，
        // 重复上面的操作，如果p节点值，那么将 root 移到其右子节点，这样当 root 为空时，res 指向的就是p的后继节点.
        // 一句话,p结点的右子节点最小值就是后续节点
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode res = null;
            while (root != null) {
                if (root.val > p.val) {
                    res = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return res;
        }

        // 当根节点值小于等于p节点值，说明p的后继节点一定在右子树中，所以对右子节点递归调用此函数，如果根节点值大于p节点值，
        // 那么有可能根节点就是p的后继节点，或者左子树中的某个节点是p的后继节点，所以先对左子节点递归调用此函数，如果返回空，
        // 说明根节点是后继节点，返回即可，如果不为空，则将那个节点返回
        public TreeNode successor(TreeNode root, TreeNode p) {
            if (root == null) {return null;}
            if (root.val <= p.val) {
                return successor(root.right, p);
            } else {
                TreeNode temp = successor(root.left, p);
                return temp != null ? temp : root;
            }
        }
    }
}
