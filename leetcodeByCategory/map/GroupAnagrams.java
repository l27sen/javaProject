package com.scotiabank.riskmanagement.testcdoe.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
