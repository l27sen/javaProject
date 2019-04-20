package leetcode.tree;

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
        leftViewTree.leftPrint(root);
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
}



