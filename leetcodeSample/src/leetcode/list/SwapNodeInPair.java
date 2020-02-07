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

    public Node reversePair(Node head){

        Node dummy = new Node(0);
        Node l1 = dummy;
        Node l2 = head;

        while (l2!=null && l2.next!=null){
            //like node '3'
            Node nextNode = l2.next.next;
            // first node is '2'
            l1.next = l2.next;
            // '2' point to '1'
            l2.next.next = l2;
            l2.next = nextNode;

            // make l1 to '3'
            l1 = l2;
            l2 = l2.next;


        }
        return dummy.next;


    }

}
