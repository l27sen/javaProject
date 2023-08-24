package leetcodeByCategory.linkedlist;

public class LinkedListCycle {

  public boolean hasCycle(ListNode22 node) {

    ListNode22 fast = node;
    ListNode22 slow = node;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast.next = fast.next.next;

      if (slow == fast) {
        return true;
      }

    }
    return false;
  }

  public ListNode22 detectCycle(ListNode22 head) {
    // Find the collision point if the list has a cycle
    if (head == null) return null;

    ListNode22 slow = head;
    ListNode22 fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) break;
    }

    // check if the list has no cycle
    if (fast == null || fast.next == null)
      return null;

    // find the entrance of the cycle
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}




class ListNode {
  int val;
  ListNode22 next;
  public ListNode(int a){
    this.val = a;
  }
}