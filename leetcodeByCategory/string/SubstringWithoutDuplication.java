package leetcodeByCategory.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * same as LongestSubstringWithoutRepeatingCharacters
 * 在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4
 * 定义两个指针指向首个字符，慢指针不动，快指针先走，每走一步，判断快指针在HashSet中是否存在，
 * 不存在，存储字符信息并继续走，直到快指针 指向重复字符串；
 * 若此时快指针-慢指针>已经记录的字符串长度，更新字符串长度；
 * 快指针不动，慢指针开始走，每走一步，将HashSet中对应的字符信息删除，
 * 直至快慢指针所指的字符相同
 * （此时快慢指针依旧是错开的，慢指针指向 快指针这个字符出现的第一次，
 * 快指针指向的是字符出现的第二次），此时不删除该字符的信息，慢指针直接++
 */

public class SubstringWithoutDuplication {

    public static int longOfSubString(String str) {
        int count = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while (end != str.length()) {
            if (!set.contains(str.charAt(end))) {
                set.add(str.charAt(end));
            } else {
                //duplicate case, maybe from teh first duplate, 
				// a b c b d, 
                if (end - start > count) count = end - start;
                //if start value not equals end, need to delete previous char, 
				//because it will start with a point after
                while (str.charAt(start) != str.charAt(end)) {
                    set.remove(str.charAt(start));
                    start++;
                }
				//need another ++, to start from the next, like 'c'
				// a b, c, b, d, 
                start++;
            }

            end++;
        }
        if (end - start > count) count = end - start;
        return count;
    }


    public int lengthOfLongestSubstring(String s) {

        int[] chars = new int[128];
        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;


            //make the windlow get small.
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static void main(String a[]) {
        System.out.println(longOfSubString("abaacde"));
    }
}
