package leetcodeByCategory.jacob;

import java.util.Stack;

/**
 *  input /a/./b/../../c/ ->> /c
 */
public class SimplifyPath {

    public static void main(String[] args){
        System.out.println(simple("/a/./b/../../c/e/"));
    }
    public static String simple(String path){

        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            String curr = arr[i].trim();
            if(curr==null||curr.equalsIgnoreCase(".")) continue;
            if(curr.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }

            }else {
                stack.push(curr);
            }
        }

        String result = "";
        while (!stack.isEmpty()){
            result = stack.pop()+ result;
        }
        return result;

    }
}
