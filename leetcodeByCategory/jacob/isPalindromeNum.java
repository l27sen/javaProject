package leetcodeByCategory.jacob;

public class isPalindromeNum {
    public static void main(String[] a){
         System.out.println(isPalindrom(1210));
    }
    public static boolean isPalindrom(int num){
        int result =0;
        int bacNum = num;
        while (num>0){
            result = result*10+ num%10;
            num = num/10;
        }
        return result == bacNum;
    }
}
