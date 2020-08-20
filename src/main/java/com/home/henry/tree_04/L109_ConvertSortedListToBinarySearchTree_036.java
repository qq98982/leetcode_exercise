package com.home.henry.tree_04;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 *  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two
 *  subtrees of every node never differ by more than 1.
 *
 *  Given the sorted linked list: [-10,-3,0,5,9],
 *
 *  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *  0
 *  / \
 *  -3   9
 *  /   /
 *  -10  5
 *
 *  这道题是要求把有序链表转为二叉搜索树，和之前那道 Convert Sorted Array to Binary Search Tree 思路完全一样，
 *  只不过是操作的数据类型有所差别，一个是数组，一个是链表。数组方便就方便在可以通过index直接访问任意一个元素，而链表不行。
 *  由于二分查找法每次需要找到中点，而链表的查找中间点可以通过快慢指针来操作，可参见有关快慢指针的应用。找到中点后，
 *  要以中点的值建立一个数的根节点，然后需要把原链表断开，分为前后两个链表，都不能包含原中节点，
 *  然后再分别对这两个链表递归调用原函数，分别连上左右子节点即可
 */
public class L109_ConvertSortedListToBinarySearchTree_036 {
    static class Solution {
        public static TreeNode sortedListToBST(ListNode head) {
            if (head == null) {return null;}
            return toBst(head, null);
        }

        private static TreeNode toBst(ListNode head, ListNode tail) {
            ListNode slow = head;
            ListNode quick = head;
            if (head == tail) {return null;}
            while (quick != tail && quick.next != tail) {
                quick = quick.next.next;
                slow = slow.next;
            }
            TreeNode midHead = new TreeNode(slow.val);
            midHead.left = toBst(head, slow);
            midHead.right = toBst(slow.next, tail);
            return midHead;
        }
    }
}
