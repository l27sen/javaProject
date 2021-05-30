package com.scotiabank.riskmanagement.testcdoe.tree;

import java.util.LinkedList;
import java.util.List;

public class PathSumInTree {

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
    System.out.println(hashPathSum(root,7));

  }


  public static boolean hashPathSum(TreeNode root, int sum) {
    List<TreeNode> list = new LinkedList<>();
    //store the level information.
    LinkedList<Integer> counts = new LinkedList<Integer>();
    list.add(root);
    counts.add(sum -root.val);
    while (!list.isEmpty()) {
      TreeNode curr = ((LinkedList<TreeNode>) list).remove();
      int currentSum = counts.remove();
      if (curr.left == null && curr.right == null && currentSum ==0) {
        return true;
      }
      if (curr.left != null) {
        list.add(curr.left);
        counts.add(currentSum- curr.left.val);
      }
      if (curr.right != null) {
        list.add(curr.right);
        counts.add(currentSum- curr.right.val);
      }
    }
    return false;
  }
}


