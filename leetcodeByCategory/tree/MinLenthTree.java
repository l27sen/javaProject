package com.scotiabank.riskmanagement.testcdoe.tree;

import java.util.LinkedList;
import java.util.List;

public class MinLenthTree {

  public static void main(String[] a) {
    TreeNode root = new TreeNode(1);
    TreeNode left1 = new TreeNode(2);
    TreeNode right1 = new TreeNode(3);
    TreeNode left1_1 = new TreeNode(4);
    TreeNode left1_2 = new TreeNode(5);

    TreeNode right1_1 = new TreeNode(6);
    TreeNode right1_2 = new TreeNode(7);

    root.left = left1;
    root.right = right1;

//        left1.left = left1_1;
//        left1.right = left1_2;

    //right1.left = right1_1;
    //right1.right = right1_2;
    System.out.println(queueLength(root));

  }


  //BFS, find the node the left and right node is null.
  public static int queueLength(TreeNode root) {
    if(root ==null){
      return 0;
    }
    List<TreeNode> list = new LinkedList<>();
    //store the level information.和queue同步的
    LinkedList<Integer> counts = new LinkedList<Integer>();
    list.add(root);
    counts.add(1);
    while (!list.isEmpty()) {
      TreeNode curr = ((LinkedList<TreeNode>) list).remove();
      int count = counts.remove();
      if (curr.left == null && curr.right == null) {
        return count;
      }
      if (curr.left != null) {
        list.add(curr.left);
        counts.add(count + 1);
      }
      if (curr.right != null) {
        list.add(curr.right);
        counts.add(count + 1);
      }
    }
    return 0;
  }
}


