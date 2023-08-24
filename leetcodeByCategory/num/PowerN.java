package leetcodeByCategory.num;

public class PowerN {

    public static void main(String[] a){
        System.out.println(myPow(3,2));

    }

    public static double power(double x, int n)
    {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return power(x, n / 2) * power(x, n / 2);

        } else {
            return x * power(x, n / 2) * power(x, n / 2);
        }
    }

    public static double myPow(double x, int n)
    {
        if (n < 0)
            return 1 / power(x, -n);
        else
            return power(x, n);
    }

}
