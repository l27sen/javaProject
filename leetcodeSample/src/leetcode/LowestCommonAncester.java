package leetcode;

import java.util.ArrayList;
import java.util.List;

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

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node left = new Node(3);
        Node right = new Node(4);

        root.left = left;
        root.right = right;

        List<Integer> lefts = new ArrayList<>();

        boolean findLeft = findPath(root, 3, lefts);
        lefts.size();
    }

}
