package main.patterns.fastslowpointers;

import main.datastructures.linkedlists.ListNode;

public class CyclicLinkedList {

    public static boolean findCycle(ListNode<Integer> head) {
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
