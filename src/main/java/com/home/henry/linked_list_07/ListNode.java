package com.home.henry.linked_list_07;

public class ListNode {

    Integer val;

    ListNode next;

    ListNode(int x) {val = x;}

    ListNode(int[] a1) {
        if (a1 == null || a1.length == 0) {
            return;
        }
        ListNode l1 = new ListNode(a1[0]);
        val = a1[0];
        next = l1;
        for (int i = 1; i < a1.length; i++) {
            l1.next = new ListNode(a1[i]);
            l1 = l1.next;
        }
        next = next.next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode() {}

    @Override
    public String toString() {
        if (this == null) {
            return "";
        }
        ListNode fast = this;
        ListNode slow = this;
        boolean circle = false;
        ListNode cross = this;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                circle = true;
                fast = this;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                cross = fast;
                break;
            }
        }
        if (!circle) {
            return val + " -> " + next;
        } else {
            slow = this;
            StringBuilder sb = new StringBuilder();
            sb.append(slow.val).append(" -> ");
            while (slow != cross) {
                slow = slow.next;
                sb.append(slow.val).append(" -> ");
            }
            slow = slow.next;
            sb.append(slow.val);
            while (slow.next != cross) {
                sb.append(" -> ");
                slow = slow.next;
                sb.append(slow.val);
            }
            sb.append(" -> ").append(cross.val);
            return sb.toString();
        }
    }
}
