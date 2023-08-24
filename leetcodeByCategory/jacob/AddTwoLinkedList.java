package leetcodeByCategory.jacob;

/**
 * 2->4->3
 * 5->6->4
 * <p>
 * result is
 * 7->0->8
 *
 * 注意handle carry
 */
public class AddTwoLinkedList {

    public CommoneList addTwo(CommoneList l1, CommoneList l2) {

        CommoneList dummy = new CommoneList(-1);
        CommoneList curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int num = l1 != null ? l1.value : 0;
            int num2 = l2 != null ? l2.value : 0;

            int sum = num + num2 + carry;
            curr.next = new CommoneList(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;

            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (carry != 0) {
            curr.next = new CommoneList(carry);
        }

        return dummy.next;
    }
}
