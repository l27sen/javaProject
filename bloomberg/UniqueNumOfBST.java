package company.bloomberg;

//https://leetcode.com/problems/unique-binary-search-trees/description/ o(n2)
public class UniqueNumOfBST {

    public static void main(String[] args){
        System.out.println(get(3));
    }
    public static int get(int num){
        if(num<=1)return 1;

        int res =0;
        for (int i = 0; i <num ; i++) {

            //left tree * right tree;
            res = res+get(i)* get(num-1 -i);

        }
        return res;
    }

    //leetcode dp

    public class Solution {
        public int numTrees(int n) {
            int[] G = new int[n + 1];
            G[0] = 1;
            G[1] = 1;

            //for each node
            for (int i = 2; i <= n; ++i) {
                //for each node as root
                for (int j = 1; j <= i; ++j) {
                    //j-1 left node
                    //i-j right node
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }
}
