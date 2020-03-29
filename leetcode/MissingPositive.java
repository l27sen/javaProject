package leetcode;

/**
 * [1,2,0] -> return 3, array length is 3, then array should be {1,2,3}
 * [3,1,4,-1] -> return 2, array length is 4, then array should be [1,2,3,4]
 */
public class MissingPositive {


    public static void main(String[] args) {
        int[] a={1,2,0};
        System.out.println(missNumber(a));
    }
    public static int missNumber(int[] num) {

        for (int i = 0; i < num.length; i++) {

            while (num[i] > 0 && num[i] < num.length && num[num[i] - 1] != num[i]) {
                //switch like bucket sort
                int temp = num[num[i] - 1];
                num[num[i] - 1] = num[i];
                num[i] = temp;
            }
        }

        //find the result for sort
        for (int i = 0; i < num.length; i++) {
            if (num[i] != i + 1) {
                return i ;
            }
        }
        return num.length + 1;


    }
}
