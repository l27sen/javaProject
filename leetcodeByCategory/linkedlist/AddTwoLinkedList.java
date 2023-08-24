package leetcodeByCategory.linkedlist;
/*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
 */
public class AddTwoLinkedList {

  public ListNode22 addTwoNumbers(ListNode22 l1, ListNode22 l2) {
    ListNode22 fake = new ListNode22(0);
    ListNode22 p = fake;

    ListNode22 p1 = l1;
    ListNode22 p2 = l2;


    int carry = 0;
    while (p1 != null || p2 != null) {
      int sum = carry;
      if (p1 != null) {
        sum += p1.value;
        p1 = p1.next;
      }

      if (p2 != null) {
        sum += p2.value;
        p2 = p2.next;
      }

      if (sum > 9) {
        carry = 1;
        sum = sum - 10;
      } else {
        carry = 0;
      }

      ListNode22 l = new ListNode22(sum);
      p.next = l;
      p = p.next;
    }

    //don't forget check the carry value at the end
    if (carry > 0) {
      ListNode22 l = new ListNode22(carry);
      p.next = l;
    }
    return fake.next;
  }
}
