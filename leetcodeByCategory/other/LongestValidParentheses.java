package leetcodeByCategory.other;

import java.util.Stack;

/**
 *
 * 1) For every ‘(’\text{‘(’}‘(’ encountered, we push its index onto the stack
 *
 * hard O（N）
 * ")()()" -> 4
 *

 */
public class LongestValidParentheses {

  public static void main(String[] a) {

    System.out.println(longestValidParentheses("()"));
  }


  public static int longestValidParentheses(String s) {
    int maxans = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    //i 是当前的index ，
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        //把之前右边括号pop掉
        stack.pop();
        if (stack.empty()) {
          //while popping the element, the stack becomes empty, we will push the current element's index onto the stack
          stack.push(i);
        } else {
          maxans = Math.max(maxans, i - stack.peek());
        }
      }
    }
    return maxans;
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
