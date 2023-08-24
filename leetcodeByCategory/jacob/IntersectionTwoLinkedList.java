package leetcodeByCategory.jacob;

//LeetCode 160. Intersection of Two Linked Lists

/**
 *A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * A，B两个linked list分别出发，遇到链表末尾后转而指向另一条链表继续遍历，那么当它们相遇时，
 * 正好是两条链表的相交点。即使没有相交点，两个指针最终也将同时指向null，这时也满足pointerA == pointerB.
 *
 */
public class IntersectionTwoLinkedList {

    public  Node2  getIntersection(Node2 nodeA, Node2 nodeB){
        Node2 headA = nodeA;
        Node2 headB = nodeB;

        while (nodeA!=nodeB){
            nodeA = nodeA==null? headB:nodeA.next;
            nodeB = nodeB==null? headA:nodeB.next;
        }

        return nodeA;
    }
}
