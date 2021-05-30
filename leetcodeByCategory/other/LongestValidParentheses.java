package com.scotiabank.riskmanagement.testcdoe.other;

import java.util.Stack;

/**
 * ")()()" -> 4
 */
public class LongestValidParentheses {

  public static void main(String[] a) {

    System.out.println(longest("((()))"));
  }

  public static int longest(String input) {

    // only the the left parentheses index.
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int start = -1;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (input.charAt(i) == ')') {
          //in case ')(())'
          if (stack.isEmpty()) {
            start = i;
          } else {
            //remove the adjecent left value, get previous index.
            stack.pop();
            //stack is empty means, use all left parentheses
            if (stack.isEmpty()) {
              result = Math.max(result, i - start);
            } else {
              //(()
              result = Math.max(result, i - stack.peek());
            }
          }
        }
      }
    }
    return result;
  }
}
