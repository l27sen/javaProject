package leetcode.list;

import java.util.ArrayDeque;

/**
 * Input: 1->2->2->1
 Output: true

 Input: 1->2
 Output: false
 */
public class PalindromeList {
    static class Node{
        Node(int value){
            this.data = value;
        }
        int data;
        Node next;
    }
    public static boolean palindrome(Node head) {
        int size = calculateSize(head);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Node curr = head;
		/* Save 1st half of list */
        for (int i = 0; i < size / 2; i++) {
            deque.push(curr.data);
            curr = curr.next;
        }
		/* If list had odd number of elements -> skip middle element */
        if (size % 2 == 1) {
            curr = curr.next;
        }
		/* Compare 2nd half of list to 1st half of list */
        while (curr != null) {
            if (deque.pop() != curr.data) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }


    public static int calculateSize(Node head) {
        if (head == null) {
            return 0;
        }
        int size = 1;
        Node n = head;
        while (n.next != null) {
            n = n.next;
            size++;
        }
        return size;
    }
}
