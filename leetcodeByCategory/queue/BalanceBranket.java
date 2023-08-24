package leetcodeByCategory.queue;

import java.util.Stack;

/**
 * 遇到左括号的时候， 加入 右括号，
 * 遇到右括号的时候， check
 */
public class BalanceBranket {

    private static boolean isBalance(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (Character character : s.toCharArray()) {
          if(character=='{'){
              stack.push('}');
          }else if(stack.isEmpty()|| stack.pop()!= character ){
              return false;
          }
        }
        //empty 表示对称
        return stack.isEmpty();
    }

    public static void main(String[] args){

        System.out.println(isBalance("{}"));
    }
}
