package leetcodeByCategory.tree;

import java.util.Stack;

/**
 *
 *   1
 *  2 3
 * 4
 * Input: root = [1,2,3,4]
 * Output: "1(2(4))(3)"
 */
public class ConstructStringFromTree {


    public static void main(String[] a){

        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);

        TreeNode left2 = new TreeNode(4);

        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left =left2;

        System.out.print(tree2str(root));



    }
    public static String tree2str(TreeNode root) {
        if(root==null)
            return "";

        if(root.left==null && root.right==null)
            return root.val+"";

        if(root.right==null)
            return root.val+"("+tree2str(root.left)+")";

        return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";
    }
}
