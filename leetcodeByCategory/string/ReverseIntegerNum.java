package leetcodeByCategory.string;

public class ReverseIntegerNum {


    public static void main(String[] a){
        System.out.println(reverse(123));
    }
    public static Integer reverse(int num){

        int result = 0;

        while (num>0){
            int model = num%10;
            result = result* 10+ model;
            num = num/10;
        }
        return result;
    }
}
