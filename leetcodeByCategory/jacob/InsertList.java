package leetcodeByCategory.jacob;


class Node2 {
    public int value;
    public Node2 next;

    public Node2(int value) {
        this.value = value;
    }
}

public class InsertList {

    public Node2 insert(Node2 head) {

        Node2 dummy = new Node2(-1);

        Node2 curr = head;
        Node2 pre = null;
        Node2 temp = null;

        while (curr != null && curr.next != null) {
            if (curr.value <= curr.next.value) {
                curr = curr.next;
            } else {
                temp = curr.next;
                //skip the one,
                curr.next = curr.next.next;
                pre = dummy;
                while (pre.next.value < temp.value) {

                    pre = pre.next;
                }

                //insert after pre.
                temp.next = pre.next;
                pre.next = temp;


            }
        }
        return dummy.next;
    }

}
