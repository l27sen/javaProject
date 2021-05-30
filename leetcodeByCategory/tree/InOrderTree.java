package com.scotiabank.riskmanagement.testcdoe.tree;

import java.util.Stack;

class Node {

  int data;
  Node left, right;

  public Node(int item) {
    data = item;
    left = right = null;
  }
}

public class InOrderTree {

  Node root;

  void inorder() {
    if (root == null) {
      return;
    }

    Stack<Node> stack = new Stack<Node>();
    Node p = root;

    // traverse the tree
    while (!stack.isEmpty() || p != null) {
      if (p != null) {
        stack.push(p);
        p = p.left;
      } else {
        Node t = stack.pop();
        System.out.println(t.data);
        p = t.right;
      }
    }
  }

  public static void main(String args[]) {

        /* creating a binary tree and entering
        the nodes */
    InOrderTree tree = new InOrderTree();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);
    tree.inorder();
  }
}
