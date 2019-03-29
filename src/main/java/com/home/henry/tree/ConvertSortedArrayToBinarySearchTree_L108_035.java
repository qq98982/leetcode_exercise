package com.home.henry.tree;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArrayToBinarySearchTree_L108_035 {

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {return null;}
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    private TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

}
