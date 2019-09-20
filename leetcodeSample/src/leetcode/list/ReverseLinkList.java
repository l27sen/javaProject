package leetcode.list;

public class ReverseLinkList {


    static class Node{
        Node(int value){
            this.value = value;
        }
        int value;
        Node next;
    }

    public static  Node reverse(Node currentNode){

        Node pre =null;
        Node next = null;

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

        Node first = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);

        first.next = sec;
        sec.next = third;

        Node re = reverse(first);
        System.out.println(re.value);


    }
}
