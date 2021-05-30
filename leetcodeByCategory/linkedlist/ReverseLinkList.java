package com.scotiabank.riskmanagement.testcdoe.linkedlist;

public class ReverseLinkList {
  public static  ListNode   reverse(ListNode currentNode){

    ListNode pre =null;
    ListNode next = null;

    while (currentNode!=null){
      //store the next value
      next = currentNode.next;
      currentNode.next = pre;
      pre = currentNode;
      currentNode = next;
    }
    return pre;
  }

  public static void main(String[] a){

    ListNode first = new ListNode(1);
    ListNode sec = new ListNode(2);
    ListNode third = new ListNode(3);

    first.next = sec;
    sec.next = third;

    ListNode re = reverse(first);
    System.out.println(re.val);


  }
}
