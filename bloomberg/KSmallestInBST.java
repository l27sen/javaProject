package company.bloomberg;

import java.util.ArrayList;

/**
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * The idea is to build an inorder traversal of BST which is
 * an array sorted in the ascending order.
 * Now the answer is the k - 1th element of this array.
 *
 *
 */
public class KSmallestInBST {


    public ArrayList <Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
}
class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}