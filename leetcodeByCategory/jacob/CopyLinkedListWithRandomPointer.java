package leetcodeByCategory.jacob;

import java.util.HashMap;
import java.util.Map;

class LinkNode{
    public  int value;
    public LinkNode next;
    public LinkNode random;
  LinkNode(int value){
      this.value = value;
  }
}
public class CopyLinkedListWithRandomPointer {

  public LinkNode copy(LinkNode head){

      //ke is old node, value is new Node.
      Map<LinkNode,LinkNode> map = new HashMap<>();

      LinkNode curr = head;

      while (curr!=null){
          map.put(curr, new LinkNode(curr.value));
          curr = curr.next;
      }

      curr = head;

      //connect together
      while (curr!=null){
          map.get(curr).next = map.get(curr.next);
          map.get(curr).random = map.get(curr.random);
          curr = curr.next;
      }

      return map.get(head);

  }
}
