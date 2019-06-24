package com.home.henry.linked_list_07;

/**
 * 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
 * talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList_L328_004 {

    static class Solution {
        // 这个思路很巧妙, 分成两段分别走, 最后将其中一段的最后的下一个指派为另外一个的head
        public ListNode oddEvenList(ListNode head) {

            if (head != null) {
                ListNode odd = head, even = head.next, evenHead = even;
                while (even != null && even.next != null) {
                    odd.next = odd.next.next;
                    even.next = even.next.next;
                    odd = odd.next;
                    even = even.next;
                }
                odd.next = evenHead;
            }
            return head;
        }
    }

}
