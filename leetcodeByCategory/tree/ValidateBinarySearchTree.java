package leetcodeByCategory.tree;

import java.util.LinkedList;

public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  /**
   * All values on the left sub tree must be less than parent and parent's parent, and all values on
   * the right sub tree must be greater than parent and parent's parent
   */
  public boolean isValidBST(TreeNode p, double min, double max) {
    if (p == null) {
      return true;
    }
    if (p.val <= min || p.val >= max) {
      return false;
    }
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
  }

  public boolean isValidBSTLoop(TreeNode root) {
    if(root == null)
      return true;

    LinkedList<BNode> queue = new LinkedList<BNode>();
    queue.add(new BNode(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
    while(!queue.isEmpty()){
      BNode b = queue.poll();
      if(b.n.val <= b.left || b.n.val >=b.right){
        return false;
      }
      if(b.n.left!=null){
        queue.offer(new BNode(b.n.left, b.left, b.n.val));
      }
      if(b.n.right!=null){
        queue.offer(new BNode(b.n.right, b.n.val, b.right));
      }
    }
    return true;
  }
}

class BNode{
  TreeNode n;
  double left;
  double right;
  public BNode(TreeNode n, double left, double right){
    this.n = n;
    this.left = left;
    this.right = right;
  }
}
