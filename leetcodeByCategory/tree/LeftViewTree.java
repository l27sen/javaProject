package com.scotiabank.riskmanagement.testcdoe.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {

    boolean printed = false;

    public static void main(String[] a) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        LeftViewTree leftViewTree = new LeftViewTree();
       // leftViewTree.leftPrint(root);

        printRightView(root);
    }

    private int findHeight(TreeNode aNode) {
        int heightLeft = 0;
        int heightRight = 0;
        if (aNode.left != null)
            heightLeft = findHeight(aNode.left);
        if (aNode.right != null)
            heightRight = findHeight(aNode.right);
        if (heightLeft > heightRight) {
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }
    }

    public void leftPrint(TreeNode root) {
        int h = findHeight(root);
        for (int i = 1; i <= h; i++) {
            printByLevel(root, i);
        }
    }

    private void printByLevel(TreeNode root, int level) {
        if (root == null) return;

        if (level == 1 && printed == false) {
            System.out.println(root.val + "\n");
            //set the tag , it is printed
            printed = true;
        } else if (level > 1) {
            //enter a new loop, reset the tag
            printed = false;
            printByLevel(root.left, level - 1);
            printByLevel(root.right, level - 1);
        }

    }


    private static void printRightView(TreeNode root)
    {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                TreeNode temp = ((LinkedList<TreeNode>) queue).pop();
                // Print the left most element at
                // the level
                if (i == 1)
                    System.out.print(temp.val + " ");
                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }













    private static void printRightView2(TreeNode root)
    {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            TreeNode node = ((LinkedList<TreeNode>) queue).pop();
            System.out.println(node.val);
            if (node.left!=null){
                ((LinkedList<TreeNode>) queue).push(node.left);
            }
            if (node.right!=null){
                ((LinkedList<TreeNode>) queue).push(node.right);
            }
        }

    }
}



