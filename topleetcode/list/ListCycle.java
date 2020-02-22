package topleetcode.list;

public class ListCycle {

    boolean checkCycleExists(ReverseLinkList.Node node) {
        ReverseLinkList.Node slow = node;
        ReverseLinkList.Node fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
