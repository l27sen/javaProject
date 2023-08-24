package leetcodeByCategory.linkedlist;

public class ReverseLinkList {
  public static ListNode22 reverse(ListNode22 currentNode){

    ListNode22 pre =null;
    ListNode22 next = null;

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

    ListNode22 first = new ListNode22(1);
    ListNode22 sec = new ListNode22(2);
    ListNode22 third = new ListNode22(3);

    first.next = sec;
    sec.next = third;

    ListNode22 re = reverse(first);
    System.out.println(re.value);


  }
}
