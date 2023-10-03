package leetcodeByCategory.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Input: word = "cbaaaabc", forbidden = ["aaa","cb"]
 * Output: 4
 * Explanation: There are 11 valid substrings in word: "c", "b", "a", "ba", "aa", "bc", "baa", "aab", "ab", "abc" and "aabc". The length of the longest valid substring is 4.
 * It can be shown that all other substrings contain either "aaa" or "cb" as a substring.
 */
public class LongestValidString {

    public static void main(String[] args) {
        String word = "cbaaaabc";
        List<String> list = Arrays.asList("aaa","cb");
        System.out.println(longestValidSubstring(word, list));
    }

    public  static int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set = new HashSet<>();
        int max = 0;
        for(String s : forbidden){
            max = Math.max(max , s.length());
            set.add(s);
        }
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            sb.append(ch +"");
            int len = sb.length();
            for(int j = len - 1 ; j >= Math.max(0 , len - max); j--){
                String s = sb.substring(j);
                if(set.contains(s)){
                    sb.delete(0 , j + 1);
                    break;

                }
            }
            ans = Math.max(sb.length() , ans);
        }
        return ans;
    }
}
