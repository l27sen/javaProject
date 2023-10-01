package leetcodeByCategory.map;

import java.util.*;

/**
 * group the anagrams together
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
  public static void main(String[] a){

    String[] test = {"et","te","ab"};
    List result = groupAnagrams(test);
    result.toArray();
  }


  public List<List<String>> groupAnagramsLeetcode(String[] strs) {
    if (strs.length == 0) return new ArrayList();
    Map<String, List> ans = new HashMap<String, List>();
    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);
      if (!ans.containsKey(key)) ans.put(key, new ArrayList());
      ans.get(key).add(s);
    }
    return new ArrayList(ans.values());
  }

  public  static  List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<List<String>>();

    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (String str : strs) {
      char[] arr = new char[26];
      //convert to order string
      for (int i = 0; i < str.length(); i++) {
        arr[str.charAt(i) - 'a']++;
      }
      String ns = new String(arr);

      if (map.containsKey(ns)) {
        map.get(ns).add(str);
      } else {
        ArrayList<String> al = new ArrayList<String>();
        al.add(str);
        map.put(ns, al);
      }
    }

    result.addAll(map.values());

    return result;
  }
}
