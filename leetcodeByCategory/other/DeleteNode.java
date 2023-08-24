package leetcodeByCategory.other;


public class DeleteNode {


  public static void main(String[] a){
    Node head = new Node(1);
    Node sec = new Node(2);
    Node third = new Node(3);
    Node four = new Node(4);

    head.next = sec;
    sec.next = third;
    third.next = four;
    deleteNode(head,third);
    System.out.println(head.data);
  }

  public static void deleteNode(Node head, Node toDeleteNode) {

    //head is the deleted one
    if (head == toDeleteNode) {
      Node temp = head;
      if (temp.next != null) {
        temp.data = temp.next.data;
        temp.next = temp.next.next;
      }
    }
    //need to find the node
    else {
      Node pre = head;
      while (pre.next != null) {
        if (pre.next.data == toDeleteNode.data) {
          break;
        }
        pre = pre.next;
      }
      if (pre.next != null) {
        pre.next = pre.next.next;
      }else{
        //pre.next is last node
        pre.next = null;
      }

    }
  }
}
