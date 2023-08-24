package leetcodeByCategory.jacob;

public class StringToInteger {

    public static void main(String[] a) {
        System.out.println(convert("12"));
    }

    public static int convert(String s) {

        int neg = 1;
        if (s.charAt(0) == '-') {
            neg = -1;
        }

        int result = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return -1;
            }
            int num = c - '0';
            result = result * 10 + num;

            i++;
        }

        return result * neg;
    }
}
