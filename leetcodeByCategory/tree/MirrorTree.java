package leetcodeByCategory.tree;


import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    //Time complexity : O(N) ,
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    public static void mirror(BinaryTreeNode root)
    {
        if(root ==null){
            return;
        }
        if(root.left ==null && root.right ==null){
            return;
        }
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }


    ////remember compare two node.
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    boolean isMirror(BinaryTreeNode node1, BinaryTreeNode node2)
    {
        // if both trees are empty, then they are mirror image
        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node1 == null) return false;


        // For two trees to be mirror images, the following
        // three conditions must be true
        // 1.) Their root node's key must be same
        // 2.) left subtree of left tree and right subtree
        // of right tree have to be mirror images
        // 3.) right subtree of left tree and left subtree
        // of right tree have to be mirror images
        if (node1 != null && node2 != null
                && node1.val == node2.val)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));

        // if none of the above conditions is true then
        // root1 and root2 are not mirror images
        return false;
    }
}

class BinaryTreeNode{
    BinaryTreeNode left = null;
    BinaryTreeNode right = null;
    int val;
    public BinaryTreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
