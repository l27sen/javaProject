package leetcode.list;

/**
 * 3->1->5 + 5->9->2, out put is 8-0-8
 */
public class addTwoList {

    static class Node {
        int value;
        Node next;
    }

    Node addList(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null) {
            return null;
        }
        Node result = new Node();
        int sum = carry;
        if (n1 != null) {
            sum += n1.value;
        }
        if (n2 != null) {
            sum += n2.value;
        }
        result.value = sum % 10;
        Node more = addList(n1 == null ? null : n1.next, n2 == null ? null : n2.next, sum > 10 ? 1 : 0);
        result.next = more;
        return result;

    }
}
