package com.scotiabank.riskmanagement.testcdoe.other;

import java.util.HashMap;
import java.util.Stack;

/**
 * Input: s = "()[]{}" Output: true 办法：左边括号一直加到stack里面，右边的就取出来比较
 */
public class ValidParentheses {

  public boolean valid(String s) {
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');

    Stack<Character> stack = new Stack();

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if (map.keySet().contains(curr)) {
        stack.push(curr);
      } else if (map.values().contains(curr)) {
        if (!stack.empty() && map.get(stack.peek()) == curr) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    //防止左边多了，不是空的
    return stack.empty();
  }
}
