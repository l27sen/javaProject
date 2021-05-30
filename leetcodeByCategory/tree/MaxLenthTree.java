package com.scotiabank.riskmanagement.testcdoe.tree;

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


    public static int dfsLength(TreeNode root){

        if (root == null) return 0;
        int leftDepth = dfsLength(root.left);
        int rightDepth = dfsLength(root.right);
        int bigger = Math.max(leftDepth, rightDepth);
        return bigger+1;


    }
}


