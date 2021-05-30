package com.scotiabank.riskmanagement.testcdoe.slidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring2("pwwkew"));
  }

  /**
   * 3. Longest Substring Without Repeating Characters Examples: Given "abcabcbb", the answer is
   * "abc", which the length is 3. Given "bbbbb", the answer is "b", with the length of 1. Given
   * "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
   * "pwke" is a subsequence and not a substring. time : O(n) space : O(n)
   */
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int result = 0;
    //j是重复的位置+1， i是当前位置
    for (int i = 0, j = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        //这个时候 map.get 还是取得之前的位置
        j = Math.max(j, map.get(s.charAt(i)) + 1);

      }
      map.put(s.charAt(i), i);
      //结果是i-j
      result = Math.max(result, i - j + 1);
    }
    return result;
  }


  public static int lengthOfLongestSubstring2(String s) {

    int left = 0;
    int right = 0;
    int max = 0;
    HashSet<Character> hashSet = new HashSet<>();
    while (right < s.length()) {

      if (!hashSet.contains(s.charAt(right))) {
        hashSet.add(s.charAt(right));
        right++;
      } else {
        //有重复的就一直remove知道没有重复的了
        hashSet.remove(s.charAt(left));
        left++;
      }
      max = Math.max(max, hashSet.size() );

    }
    return max;

  }

}
