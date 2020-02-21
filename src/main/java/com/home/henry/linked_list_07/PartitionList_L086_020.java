package com.home.henry.linked_list_07;

/**
 * 86. Partition List
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 */
public class PartitionList_L086_020 {

    static class Solution {
        public static ListNode partition(ListNode head, int x) {
            ListNode smallHead = new ListNode(0), bigHead = new ListNode(0),
                    small = smallHead, big = bigHead;
            while (head != null) {
                ListNode temp = new ListNode(head.val);
                if (head.val < x) {
                    small.next = temp;
                    small = small.next;
                } else {
                    big.next = temp;
                    big = big.next;
                }
                head = head.next;
            }
            small.next = bigHead.next;
            return smallHead.next;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.partition(new ListNode(new int[] { 1, 4, 3, 2, 5, 2 }), 3));
        System.out.println(Solution.partition(new ListNode(new int[] { 3,1 }), 2));
        System.out.println(Solution.partition(new ListNode(new int[] { 1,2,3 }), 4));
    }
}
