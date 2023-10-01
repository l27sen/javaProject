package leetcodeByCategory.tree;

/**
 *
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 *
 */
public class MergeTree {

  public static void main(String[] a){
    Node root1 = new Node(1);
    Node left = new Node(2);
    root1.left = left;
    Node root2 = new Node(2);
    Node rightNode = new Node(4);

    root2.right =rightNode;

    Node merged = MergeTrees(root1, root2);
    System.out.println(merged);

  }

  static Node MergeTrees(Node t1, Node t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    t1.data += t2.data;
    t1.left = MergeTrees(t1.left, t2.left);
    t1.right = MergeTrees(t1.right, t2.right);
    return t1;
  }
}
