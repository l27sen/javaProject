package leetcodeByCategory.linkedlist;

public class ListCycle {

    boolean checkCycleExists(ListNode22 node) {
        ListNode22 slow = node;
        ListNode22 fast = node;

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
