package leetcodeByCategory.jacob;

public class DivideTwoInteger {

    public static void main(String[] a){
        System.out.println(divide( 19, 3));
    }

    public static int divide(int dividend, int divisor){

        int result =0;
        int ldividend = dividend;
        int ldivisor = divisor;
        while (ldivisor <=ldividend){
           int temp = ldivisor;
           //record every 2 factor
           int mul =1;
           while (ldividend >= (temp*2)){
               temp = temp*2;
               mul = mul*2;
           }
           result = result+mul;
           ldividend = ldividend- temp;
        }

        return result;
    }
}
