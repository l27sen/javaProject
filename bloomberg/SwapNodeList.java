package company.bloomberg;
 class SwapNode {
      int val;
    SwapNode next;
    SwapNode(int x) { val = x; }
  }
public class SwapNodeList {

    public SwapNode swapPairs(SwapNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        SwapNode dummy = new SwapNode(-1);
        dummy.next = head;

        SwapNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            SwapNode firstNode = head;
            SwapNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
