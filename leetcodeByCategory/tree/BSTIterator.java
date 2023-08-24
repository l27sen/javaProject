package leetcodeByCategory.tree;

import java.util.Stack;

public class BSTIterator {

    private TreeNode curr;
    private Stack<TreeNode> stack;
    public int next(){

        while(curr!=null){
            stack.push(curr);
            curr= curr.left;
        }

        curr = stack.pop();
        int value = curr.val;
        curr = curr.right;
        return value;

    }
}
