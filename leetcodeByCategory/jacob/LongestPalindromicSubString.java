package leetcodeByCategory.jacob;

/**
 * nput: str = “forgeeksskeegfor”
 * Output: “geeksskeeg”
 * Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.
 * <p>
 * Input: str = “Geeks”
 * Output: “ee”
 *
 * time: O(n2).
 */
public class LongestPalindromicSubString {

    //begin point of the char
    int begin = 0;
    int maxLength = 0;

    //Expand From Centers
    public String longest(String s) {

        for (int i = 0; i < s.length(); i++) {

            //two case/
            //aba case
            helper(s, i, i);
            //aabb case.
            helper(s, i, i + 1);
        }

        return s.substring(begin, begin + maxLength);

    }

    private void helper(String s, int left, int right) {

        while (left >= 0 && right <= s.length() && s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLength) {
                begin = left;
                maxLength = right - left + 1;
            }
            left--;
            right++;
        }
    }
}
