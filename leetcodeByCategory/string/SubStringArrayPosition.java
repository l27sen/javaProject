package com.scotiabank.riskmanagement.testcdoe.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the length of each word in array are the same s = barfoothefoobarcb, words [foo, bar] outpout is
 * [0,9]
 */
public class SubStringArrayPosition {

  public List<Integer> findSubString(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    int wordsNum = words.length;
    int singleLength = words[0].length();
    Map<String, Integer> map = new HashMap<>();
    for (String str : words) {
      map.put(str, map.getOrDefault(str, 0) + 1);

    }
    for (int i = 0; i <= s.length() - wordsNum * singleLength; i++) {
      Map<String, Integer> copy = new HashMap<>(map);

      int k = wordsNum;
      int j = i;

      while (k > 0) {
        //extract the value by word lenth
        String currentValue = s.substring(j, j + singleLength);
        //can't find or alreay find
        if (!copy.containsKey(currentValue) || copy.get(currentValue) < 1) {
          break;
        }
        //if current value in the hashMap
        copy.put(currentValue, copy.get(currentValue) - 1);

        k--;
        j = j + singleLength;
      }

      if (k == 0) {
        result.add(i);
      }

    }

    return result;
  }

}
