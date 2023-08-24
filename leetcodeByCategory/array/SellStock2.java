package leetcodeByCategory.array;


//思路，只要后一个比前一个大，就一直加
public class SellStock2 {


    public static void main(String[] a){
        int[] price ={7,1,5,3,6,4};
        System.out.println(sell(price));
    }
    public static int sell(int[] a) {
        if (a.length <= 1) return 0;

        int result = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                result+= a[i] - a[i - 1];
            }
        }

        return result;
    }
}
