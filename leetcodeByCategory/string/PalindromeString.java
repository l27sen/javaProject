package leetcodeByCategory.string;

/**
 * Single Word Palindromes
 * Anna
 * Civic
 * Kayak
 */
public class PalindromeString {

    public static void main(String a[]) {

        System.out.print(isPalindromeString("bab"));
    }

    //aba is true
    private static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
        System.out.println(length / 2);
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }

    //leetcode

    /**
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }
}
