package leetcode.num;

public class isPalindromNum {

    /**
     * 121, true,
     * 1221, true,
     * 1232 , false
     */
    public static boolean isPalinDrom(int input) {
        int reverse = 0;
        int num = input;
        while (input > 0) {
            reverse = reverse * 10 + input % 10;
            input = input / 10;
        }
        return reverse == num;
    }

    public static void main(String[] a) {
        System.out.println(isPalinDrom(121));
    }
}
