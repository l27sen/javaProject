package leetcode.list;

/**
 * 1 2,3 4 --> 2 1 4 3
 */
public class SwapNodeInPair {

    static class Node{
        Node(int value){
            this.value = value;
        }
        int value;
        Node next;
    }

    public static void main(String[] a){
        Node head = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        head.next = sec;
        sec.next = third;
        third.next = forth;

        reversePair(head);
        head.toString();

    }

    public static void reversePair(Node head){
        Node temp = head;

        while (temp!=null && temp.next!=null){
            int k = temp.value;
            temp.value = temp.next.value;
            temp.next.value = k;
            temp = temp.next.next;
        }



    }

}
