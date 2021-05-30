package com.scotiabank.riskmanagement.testcdoe.linkedlist;


public class RemoveDuplicateFromList {

  public static void main(String[] a){

    ListNode listNode = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    ListNode listNode3 = new ListNode(2);
    listNode.next = listNode2;
    listNode2.next = listNode3;

    ListNode noDupNode = deleteDuplicates2(listNode);
    System.out.println(noDupNode.val);
  }

  /**
   * Input: head = [1,1,2] Output: [1,2]
   * Input: head = [1,1,2,3,3] Output: [1,2,3] 思路：两个指针，向前走
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode prev = head;
    ListNode p = head.next;

    while (p != null) {
      if (p.val == prev.val) {
        //pre 没有动
        prev.next = p.next;
        p = p.next;
        //no change prev, go to next.
      } else {
        prev = p;
        p = p.next;
      }
    }

    return head;
  }


  /**
   * given 1->1->1->2->3, return 2->3.
   * 完全remove 重复的
   * @param head
   * @return
   */
  public static ListNode deleteDuplicates2(ListNode head) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;


    ListNode current = dummy;
    //from head compare, at least two node
    while (current.next != null && current.next.next != null) {
      if (current.next.val == current.next.next.val) {
        int dup = current.next.val;
        while (current.next != null && current.next.val == dup) {
          //remove the first, then go to the next
          current.next = current.next.next;
        }
        //no current=current.next.
        //因为后面的还可能重复， 3,3,4,4
      } else {
        current = current.next;
      }

    }

    return dummy.next;
  }
}
