package leetcode.tree;

public class SubTree {

    public static void main(String[] a){
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);


        root.left = left1;
        root.right = right1;

        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        root2.left = left2;
        root2.right = right2;
        System.out.println(containsTree(root, root2));

    }

    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true; // The empty tree is a subtree of every tree.
        }
        return subTree(t1, t2);
    }

    /* Checks if the binary tree rooted at r1 contains the binary tree
     * rooted at r2 as a subtree somewhere within it.
     */
    public static boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false; // big tree empty & subtree still not found.
        } else if (r1.val == r2.val && matchTree(r1,r2)) {
            return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    /* Checks if the binary tree rooted at r1 contains the
     * binary tree rooted at r2 as a subtree starting at r1.
     */
    public static boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true; // nothing left in the subtree
        } else if (r1 == null || r2 == null) {
            return false; // exactly one tree is empty, therefore trees don't match
        } else if (r1.val != r2.val) {
            return false;  // data doesn't match
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
}
