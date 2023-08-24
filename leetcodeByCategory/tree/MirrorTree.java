package leetcodeByCategory.tree;


import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

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
