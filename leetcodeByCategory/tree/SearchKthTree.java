package com.scotiabank.riskmanagement.testcdoe.tree;

import java.util.List;
import java.util.Stack;

public class SearchKthTree {


    public static void searchTree(TNode tNode, int[] a) {
        if (tNode.left != null) {
            searchTree(tNode.left, a);
        }
        //check if sequence num is 1, means found,
        if (a[0] == 1) {
            System.out.println("found node " + tNode.val);
            return;
        } else {
            //reduce the sequence
            a[0]--;
        }

        if (tNode.right != null) {
            searchTree(tNode.right, a);
        }
    }

    public static void main(String[] args) {
        TNode n1 = new TNode(2);
        TNode n2 = new TNode(1);
        TNode n3 = new TNode(3);

        n1.left = n2;
        n1.right = n3;
        int[] tmp = {2};
        System.out.println(kthSmallest(n1, 2));


    }

    //inorder query
    public static int kthSmallest(TNode root, int k) {
        Stack<TNode> stack = new Stack<TNode>();

        TNode p = root;
        int result = 0;

        while(!stack.isEmpty() || p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                TNode t = stack.pop();
                k--;
                if(k==0)
                    result = t.val;
                p = t.right;
            }
        }

        return result;
    }

}


class TNode {
    TNode left = null;
    TNode right = null;
    int val;

    public TNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
