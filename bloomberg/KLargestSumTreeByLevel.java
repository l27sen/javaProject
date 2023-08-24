package company.bloomberg;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Input: root = [5,8,9,2,1,3,7,4,6], k = 2
 * Output: 13
 * Explanation: The level sums are the following:
 * - Level 1: 5.
 * - Level 2: 8 + 9 = 17.
 * - Level 3: 2 + 1 + 3 + 7 = 13.
 * - Level 4: 4 + 6 = 10.
 * The 2nd largest level sum is 13.
 *
 * BFS+heap
 */
public class KLargestSumTreeByLevel {

    public long kthLargestLevelSum(T1Node root, int k) {
        Queue<Long> minHeap = new PriorityQueue<>();
        List<T1Node> curLevel = new ArrayList<>();
        curLevel.add(root);
        while (!curLevel.isEmpty()) {
            List<T1Node> nextLevel = new ArrayList<>();
            long s = 0;
            for (T1Node node : curLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                s += node.val;
            }
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            curLevel = nextLevel;
        }
        return minHeap.size() == k ? minHeap.peek() : -1;
    }
}


 class T1Node {
    int val;
    T1Node left;
    T1Node right;

    T1Node() {
    }

    T1Node(int val) {
        this.val = val;
    }

    T1Node(int val, T1Node left, T1Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
