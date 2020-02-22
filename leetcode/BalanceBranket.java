package leetcode;

import java.util.Stack;

public class BalanceBranket {

    private static boolean isBalance(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (Character character : s.toCharArray()) {
            if (character == '{') {
                //store the expect char }
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != character) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println(isBalance("[]"));
    }
}
