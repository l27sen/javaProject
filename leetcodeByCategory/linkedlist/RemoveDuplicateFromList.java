package leetcodeByCategory.linkedlist;


public class RemoveDuplicateFromList {

  public static void main(String[] a){

    ListNode22 listNode = new ListNode22(1);
    ListNode22 listNode2 = new ListNode22(1);
    ListNode22 listNode3 = new ListNode22(2);
    listNode.next = listNode2;
    listNode2.next = listNode3;

    ListNode22 noDupNode = deleteDuplicates2(listNode);
  }

  /**
   * Input: head = [1,1,2] Output: [1,2]
   * Input: head = [1,1,2,3,3] Output: [1,2,3] 思路：两个指针，向前走
   */
  public ListNode22 deleteDuplicates(ListNode22 head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode22 prev = head;
    ListNode22 p = head.next;

    while (p != null) {
      if (p.value == prev.value) {
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
  public static ListNode22 deleteDuplicates2(ListNode22 head) {
    ListNode22 dummy = new ListNode22(-1);
    dummy.next = head;


    ListNode22 current = dummy;
    //from head compare, at least two node
    while (current.next != null && current.next.next != null) {
      if (current.next.value == current.next.next.value) {
        int dup = current.next.value;
        while (current.next != null && current.next.value == dup) {
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
