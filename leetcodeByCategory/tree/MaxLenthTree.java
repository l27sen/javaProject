package leetcodeByCategory.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaxLenthTree {

    public static void main(String[] a){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left1_1 = new TreeNode(4);
        TreeNode left1_2 = new TreeNode(5);

        TreeNode right1_1 = new TreeNode(6);
        TreeNode right1_2 = new TreeNode(7);

        root.left = left1;
        //root.right = right1;

        left1.left = left1_1;
        left1.right = left1_2;

        //right1.left = right1_1;
        //right1.right = right1_2;
        System.out.println(dfsLength(root));

    }


    // time complexity is O(N)
    public static int dfsLength(TreeNode root){

        if (root == null) {
            return 0;
        } else {
            int left_height = dfsLength(root.left);
            int right_height = dfsLength(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }


    }

    //BFS way

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        int depth = 0, next = 0;
        TreeNode cur;
        dq.offer(root);

        while (!dq.isEmpty()) {
            depth++;
            next = dq.size();
            for (int i = 0; i < next; ++i) {
                cur = dq.poll();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
        }
        return depth;
    }
}


