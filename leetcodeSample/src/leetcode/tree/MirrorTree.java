package leetcode.tree;



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
