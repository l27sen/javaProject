package leetcode.tree;

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

    public static void print(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        List<BinaryTreeNode> list = new LinkedList<>();
        BinaryTreeNode node;
        // 当前层的结点个数
        int current = 1;
        // 记录下一层的结点个数
        int next = 0;
        list.add(root);

        while (list.size() > 0) {
            node = list.remove(0);
            current--;
            System.out.printf("%-3d", node.val);

            if (node.left != null) {
                list.add(node.left);
                next++;
            }
            if (node.right != null) {
                list.add(node.right);
                next++;
            }

            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
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
//        n2.left = n4;
//        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;
//        n4.left = n8;
//        n4.right = n9;

        print(n1);

    }


    //按之字形顺序打印二叉树

    static void printTreeLikeSnake(BinaryTreeNode root) {


        List<BinaryTreeNode> current = new LinkedList<>();
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
