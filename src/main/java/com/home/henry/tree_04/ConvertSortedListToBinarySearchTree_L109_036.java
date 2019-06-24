package com.home.henry.tree_04;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * 和108类似, 但是又进了一步
 */
public class ConvertSortedListToBinarySearchTree_L109_036 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {return null;}
        return toBst(head, null);
    }

    private TreeNode toBst(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode quick = head;
        if (head == tail) {return null;}
        while(quick!=tail && quick.next!=tail) {
            quick = quick.next.next;
            slow = slow.next;
        }
        TreeNode tHead = new TreeNode(slow.val);
        tHead.left = toBst(head, slow);
        tHead.right = toBst(slow.next, tail);
        return tHead;
    }
}
