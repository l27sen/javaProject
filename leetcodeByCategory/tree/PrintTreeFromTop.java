package leetcodeByCategory.tree;

import java.util.LinkedList;

public class PrintTreeFromTop {

    public static void main(String[] a){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left1_1 = new TreeNode(4);
        TreeNode left1_2 = new TreeNode(5);

        TreeNode right1_1 = new TreeNode(6);
        TreeNode right1_2 = new TreeNode(7);

        root.left = left1;
        root.right = right1;

        left1.left = left1_1;
        left1.right = left1_2;

        right1.left = right1_1;
        right1.right = right1_2;
        printFromTopToBottom(root);

    }


    public static void printFromTopToBottom(TreeNode root){
        if (root == null) System.out.println("树为空");
        // 利用链表生成队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
    }
}



class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
