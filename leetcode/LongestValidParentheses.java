package leetcode;

import java.util.Stack;

/**
 * ")()()" -> 4
 */
public class LongestValidParentheses {
    public static void main(String[] a) {
        longest("(()");
    }

    public static int longest(String input) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int start = -1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else {
                //if it is ')'
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        result = Math.max(result, i - start);
                    } else {
                        //if still not empty "(()" case
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }
        return result;
    }
}
