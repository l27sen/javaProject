package leetcodeByCategory.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PringTreeByLevel {

    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    //Time complexity : O(N) since each node is processed
    //exactly once
    //add to result by level
    public static List<List<Integer>> print(BinaryTreeNode root ) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        List<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            int size = queue.size();
            //get current level data.
            for (int i = 0; i <size ; i++) {
                BinaryTreeNode current = ((LinkedList<BinaryTreeNode>) queue).poll();
                currentList.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

            }

            resultList.add(currentList);

        }
        return resultList;
    }


    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/editorial/


    public static List<List<Integer>> connectEachLevel(BinaryTreeNode root ) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return null;
        }
        List<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            int size = queue.size();
            //get current level data.
            for (int i = 0; i <size ; i++) {
                BinaryTreeNode current = ((LinkedList<BinaryTreeNode>) queue).poll();
                currentList.add(current.val);

                if (i < size - 1) {
                    //connect each
               //     current.next = queue.peek();
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

            }

            resultList.add(currentList);

        }
        return resultList;
    }


    public static boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    public static boolean isSymmetrical(BinaryTreeNode left, BinaryTreeNode right) {

        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null) {
            return false;
        }

        if (right.val != left.val) {
            return false;
        }

        return isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }


    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        BinaryTreeNode n9 = new BinaryTreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;
//        n4.left = n8;
//        n4.right = n9;

       List<List<Integer>> resultList =  print(n1);
        resultList.size();

        printTreeLikeSnake(n1);

    }


    //按之字形顺序打印二叉树 zigzag
    static void printTreeLikeSnake(BinaryTreeNode root) {


        List<BinaryTreeNode> current = new LinkedList<>();
        //store the level order
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while (current.size() > 0) {

            //get last node
            node = current.remove(current.size() - 1);
            System.out.println("node " + node.val);

            if (flag == 0) {
                if (node.left != null) {
                    reverse.add(node.left);
                }
                if (node.right != null) {
                    reverse.add(node.right);
                }

            } else {
                //先加的后出
                if (node.right != null) {
                    reverse.add(node.right);
                }
                if (node.left != null) {
                    reverse.add(node.left);
                }

            }

            //switch current to reverse.
            if (current.size() == 0) {
                flag = 1 - flag;
                List temp = current;
                current = reverse;
                reverse = temp;

            }
        }
    }


    //序列化和反序列化二叉树
    public static void serialize(BinaryTreeNode root, List<Integer> result) {

        List<BinaryTreeNode> list = new LinkedList<>();
        list.add(root);
        BinaryTreeNode node;
        while (list.size() > 0) {
            node = list.remove(0);
            //even node is null, then still add to result.
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                list.add(node.left);
                list.add(node.right);
            }
        }
    }

    // deserialize the tree from list
    public static BinaryTreeNode deserialize(List<Integer> result, int index) {

        if (result.size() < 1 || index < 0 || result.size() <= index || result.get(index) == null) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(result.get(index));
        root.left = deserialize(result, index * 2 + 1);
        root.right = deserialize(result, index * 2 + 2);
        return root;

    }


}
