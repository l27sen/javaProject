package leetcodeByCategory.linkedlist;

public class MergeTwoLinkList {


    static class Node{
        int value;
        Node next;
    }

    public static Node merge(Node head1, Node head2) {

        Node root = new Node();
        Node pointer = root;
        while (head1 != null && head2 != null) {
            if(head1.value< head2.value){
                pointer.next = head1;
                head1 = head1.next;
            }else{
                pointer.next = head2;
                head2=head2.next;
            }

            pointer = pointer.next;
        }

        if(head1!=null){
            pointer.next = head1;
        }
        if(head2!=null){
            pointer.next = head2;
        }

        return root.next;

    }
}
