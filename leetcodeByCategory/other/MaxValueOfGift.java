package leetcodeByCategory.other;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class MaxValueOfGift {

    /**
     * 1   10  3   8
     * 12  2   9   6
     * 5   7   4   11
     * 3   7   16  5
     *
     * @param data
     * @return
     */
    public static int getMaxVaule2(int[][] data) {
        System.out.println(new Date().getTime());
        if (data.length == 0 || data[0].length == 0)
            return 0;
        int maxRowIndex = data.length - 1;
        int maxColIndex = data[0].length - 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, data[0][0]));
        Node nodeCur = null;
        //图的遍历，把所有结点加进去 ，再求和
        //while 条件是一般走，直到最数组的最下边
        while (queue.peek().row != maxRowIndex || queue.peek().col != maxColIndex) {
            nodeCur = queue.poll();
            if (nodeCur.row != maxRowIndex) {
                queue.offer(new Node(nodeCur.row + 1, nodeCur.col, nodeCur.sum + data[nodeCur.row + 1][nodeCur.col]));
            }
            if (nodeCur.col != maxColIndex) {
                queue.offer(new Node(nodeCur.row, nodeCur.col + 1, nodeCur.sum + data[nodeCur.row][nodeCur.col + 1]));
            }
        }
        int maxSum = 0, temp;
        while (!queue.isEmpty()) {
            temp = queue.poll().sum;
            if (temp > maxSum)
                maxSum = temp;
        }
        System.out.println(new Date().getTime());

        return maxSum;
    }

    public static class Node {
        int row;
        int col;
        int sum;

        public Node(int r, int c, int s) {
            row = r;
            col = c;
            sum = s;
        }
    }

    public static void main(String[] args) {
        int[][] data = {
            {1, 10, 3, 8},
            {12, 2, 9, 6},
            {5, 7, 4, 11},
            {3, 7, 16, 5}};


        int[][] data2= {
            {1, 10},
            {12, 2}
            };
        System.out.println(getMaxVaule2(data2));
    }
}
