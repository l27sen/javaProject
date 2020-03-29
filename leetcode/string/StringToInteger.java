package leetcode.string;

public class StringToInteger {

    public static int convert(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        int result = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return result * sign;
            }
            result = result * 10 + str.charAt(i) - '0';
        }
        return result;
    }


    public static void main(String[] a){
        System.out.println(convert("-234"));
    }
}
