package leetcodeByCategory.tree;

import leetcodeByCategory.linkedlist.ListNode22;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int a){
        this.val = a;
    }
}
public class ConvertSortedListToBinarySearchTree {



    //yong array
    public TreeNode sortedArrayToBST(int[] num) {
        return buildTree(num, 0, num.length - 1);
    }
    public TreeNode buildTree(int[] num, int start, int end){
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildTree(num, start, mid - 1);
        root.right = buildTree(num, mid + 1, end);
        return root;
    }

    private ListNode findMiddleElement(ListNode head) {

        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }

    //Time Complexity: O(NlogN)
    public TreeNode sortedListToBST(ListNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        ListNode mid = this.findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
}
