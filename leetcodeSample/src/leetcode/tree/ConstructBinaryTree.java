package leetcode.tree;

import java.util.Arrays;

public class ConstructBinaryTree {

    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int value){
            this.value = value;
        }
    }


        public static BinaryTreeNode reConstructBinaryTree(int [] pre, int [] in){
            /**
             * 通过前序遍历数组和中序遍历数组来构建二叉树。
             * @param pre 前序遍历数组
             * @param in 中序遍历数组
             * @return 要得到的二叉树
             */
            // 判断三连
            if(pre == null || in == null){
                return null;
            }
            if(pre.length == 0 || in.length == 0){
                return null;
            }
            if(pre.length != in.length){
                return  null;
            }
            BinaryTreeNode root = new BinaryTreeNode(pre[0]);
            for(int i = 0; i < pre.length; i++){
                if (pre[0] == in[i]){
                    root.left = reConstructBinaryTree(
                            Arrays.copyOfRange(pre, 1, i+1),
                            Arrays.copyOfRange(in, 0, i)
                    );
                    root.right = reConstructBinaryTree(
                            Arrays.copyOfRange(pre, i+1, pre.length),
                            Arrays.copyOfRange(in, i+1, in.length)
                    );
                }
            }
            return root;
        }




    public static void main(String[] args) {
//        String pre = "12473568";
//        String in = "47215386";

        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};

//        BinaryTreeNode root = constructCore(pre, in);
        BinaryTreeNode root = reConstructBinaryTree(pre, in);

        pos(root);
    }

    private static void pos(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            pos(root.left);
        }
        if (root.right != null) {
            pos(root.right);
        }
        System.out.println(root.value);
    }
}
