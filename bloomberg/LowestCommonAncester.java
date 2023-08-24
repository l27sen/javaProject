package company.bloomberg;


import java.util.*;

//思路： 按照InOrder去查找， 存储住路径，
public class LowestCommonAncester {

    static class Node {
        Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }

    private static boolean findPath(Node root, int n, List<Integer> path) {
        if (root == null) {
            return false;
        }
        path.add(root.value);
        if (root.value == n) {
            return true;
        }
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
        //if can not find, remove last one
//        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node left = new Node(3);
        Node right = new Node(4);

        root.left = left;
        root.right = right;

        List<Integer> path = new ArrayList<>();

        boolean findLeft = findPath(root, 4, path);
        path.size();
    }

    //find last common node in two list
    public static Node getLastCommonNode(List<Node> p1, List<Node> p2) {
        Iterator<Node> ite1 = p1.iterator();
        Iterator<Node> ite2 = p2.iterator();
        Node last = null;

        while (ite1.hasNext() && ite2.hasNext()) {
            Node tmp = ite1.next();
            if (tmp == ite2.next()) {
                last = tmp;
            }
        }

        return last;

    }


    //another way

    /**
     *
     * Start from the root node and traverse the tree.
     * Until we find p and q both, keep storing the parent pointers in a dictionary.
     * Once we have found both p and q, we get all the ancestors for p using the parent dictionary and add to a set called ancestors.
     * Similarly, we traverse through ancestors for node q. If the ancestor is present in the ancestors set for p,
     * this means this is the first ancestor common between p and q (while traversing upwards) and hence this is the LCA node.
     * 思路 stack遍历树，存马屁，  用map 存 parent node， 用 ancestor 存一个节点的路径， 然后判断是否包括另外一个节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public CommonTree lowestCommonAncestor(CommonTree root, CommonTree p, CommonTree q) {

        // Stack for tree traversal
        Deque<CommonTree> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<CommonTree, CommonTree> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            CommonTree node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<CommonTree> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            //go to parent
            q = parent.get(q);
        return q;
    }


}

class CommonTree{
    CommonTree left = null;
    CommonTree right = null;
    int val;
    public CommonTree(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
