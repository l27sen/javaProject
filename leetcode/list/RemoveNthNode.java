package leetcode.list;



/**
 * 1_2_3_4 , n=2, -> 1->2->3, remove倒数第二
 */
public class RemoveNthNode {

    static class Node{
        int value;
        Node next;
    }


    /*
    remove last N th node
     */
    public Node removeNthNode(Node head, int n){

        Node dumy = new Node();
        Node slow = dumy;
        Node fast = dumy;
        dumy.next = head;

        //fast move n steps
        for (int i=0;i<=n;i++){
            fast= fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        //then slow is the N th node;
        slow.next = slow.next.next;
        return dumy.next;
    }
}
