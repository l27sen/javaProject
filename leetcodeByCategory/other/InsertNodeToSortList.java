package leetcodeByCategory.other;

public class InsertNodeToSortList {

  public static void main(String[] a){
    Node head = new Node(2);
    Node sec = new Node(3);
    Node third = new Node(4);
    head.next = sec;
    sec.next = third;
    insertNode(head,new Node(1));
    System.out.println(head.data);
  }


  public static void insertNode(Node head, Node addNode) {

    Node current = head;
    if (current.data > addNode.data) {
      addNode.next = current;
      current = addNode;
    } else {
      Node pre = head;
      while (pre.next != null && pre.next.data < addNode.data) {
        pre = pre.next;
      }
      //this one is big
      Node temp = pre.next;
      pre.next = addNode;
      addNode.next= temp;

    }
  }


}


