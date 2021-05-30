package com.scotiabank.riskmanagement.testcdoe.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//思路： 按照InOrder去查找， 存储住路径，
public class LowestCommonAncester {

    static class Node {
        Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }

    private static boolean findPath(Node root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.value);
        if (root.value == n) {
            return true;
        }
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
        //if can not find, remove last one
//        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node left = new Node(3);
        Node right = new Node(4);

        root.left = left;
        root.right = right;

        List<Integer> path = new ArrayList<>();

        boolean findLeft = findPath(root, 4, path);
        path.size();
    }

    //find last common node in two list
    public static Node getLastCommonNode(List<Node> p1, List<Node> p2) {
        Iterator<Node> ite1 = p1.iterator();
        Iterator<Node> ite2 = p2.iterator();
        Node last = null;

        while (ite1.hasNext() && ite2.hasNext()) {
            Node tmp = ite1.next();
            if (tmp == ite2.next()) {
                last = tmp;
            }
        }

        return last;

    }


    //another way

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p) return p;
        if(root == q) return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        return left != null ? left : right;
    }


}
