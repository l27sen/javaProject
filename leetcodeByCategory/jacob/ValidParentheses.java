package leetcodeByCategory.jacob;

import java.util.Stack;

public class ValidParentheses {

    public boolean valid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else {
                //pop get the value
                if (stack.isEmpty()) {
                    return false;
                }
                //把里面对职pop出来，比较
                char currentValue = stack.pop();
                if (currentValue != c) {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
