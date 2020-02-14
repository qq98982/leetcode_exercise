package com.home.henry.linked_list_07;

public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) { val = x; }

    @Override
    public String toString() {
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
